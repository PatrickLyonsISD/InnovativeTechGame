/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.TechTusQuiz.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.TechTusQuiz.data.Question
import com.example.TechTusQuiz.data.QuestionsRepository



class QuizViewModel: ViewModel() {
    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    private val _currentQuestionIndex = MutableLiveData(0)
    val currentQuestionIndex: LiveData<Int> = _currentQuestionIndex

    private val _currentScore = MutableLiveData(0)
    val currentScore: LiveData<Int> = _currentScore

    private val _currentQuestion = MediatorLiveData<Question>()
    val currentQuestion: LiveData<Question> = _currentQuestion

    private val _isGameOver = MutableLiveData(false)
    val isGameOver: LiveData<Boolean> = _isGameOver

    private val _selectedAnswerExplanation = MutableLiveData<String?>(null)
    val selectedAnswerExplanation: LiveData<String?> = _selectedAnswerExplanation

    private val questionsRepository = QuestionsRepository()

    init {
        loadQuestions()
        _currentQuestion.addSource(_questions) { questions ->
            _currentQuestion.value = questions[_currentQuestionIndex.value ?: 0]
        }
        _currentQuestion.addSource(_currentQuestionIndex) { index ->
            _questions.value?.let {
                _currentQuestion.value = it[index]
            }
        }
    }

    fun loadQuestions() {
        _questions.value = questionsRepository.getQuestions()
    }

    fun resetGame(){
        _currentQuestionIndex.value = 0
        _currentScore.value = 0
        _isGameOver.value = false
        loadQuestions()
    }

    fun submitAnswer(answerIndex: Int) {
        if (_isGameOver.value == true) {
            return
        }
        val question = _currentQuestion.value ?: return
        _selectedAnswerExplanation.value = question.explanation
        if (question.correctAnswerIndex == answerIndex) {
            _currentScore.value = (_currentScore.value ?: 0) + 1
        }
        // Don't move to the next question immediately
    }

    fun proceedToNextQuestion() {
        val nextIndex = (_currentQuestionIndex.value ?: 0) + 1
        if (nextIndex < (_questions.value?.size ?: 0)) {
            _currentQuestionIndex.value = nextIndex
        } else {
            _isGameOver.value = true
        }
        resetExplanation()
    }
    private fun moveToNextQuestion() {
        val nextIndex = (_currentQuestionIndex.value ?: 0) + 1
        if (nextIndex < (_questions.value?.size ?: 0)) {
            _currentQuestionIndex.value = nextIndex
            _selectedAnswerExplanation.value = null // Reset selected answer for next question
        } else {
            _isGameOver.value = true
        }
    }

    fun resetExplanation() {
        _selectedAnswerExplanation.value = null
    }

    private fun checkGameOver() {
        _isGameOver.value = (_currentQuestionIndex.value ?: 0) >= (_questions.value?.size ?: 0)
    }
}

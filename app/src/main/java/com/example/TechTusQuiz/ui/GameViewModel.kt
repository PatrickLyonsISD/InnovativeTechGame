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
import com.example.TechTusQuiz.data.Difficulty
import com.example.TechTusQuiz.data.Question
import com.example.TechTusQuiz.data.QuestionsRepository
import com.example.TechTusQuiz.data.UserProgress
import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModelProvider
import com.example.unscramble.R

class SoundManager(private val context: Context) {

    fun playCorrectAnswerSound() {
        playSound(R.raw.game_sound_correct)
    }

    fun playWrongAnswerSound() {
        playSound(R.raw.game_sound_wrong)
    }

    fun playCongratulationsSound() {
        playSound(R.raw.level_up_voice)
    }
    private fun playSound(soundResourceId: Int) {
        MediaPlayer.create(context, soundResourceId).apply {
            setOnCompletionListener { mp -> mp.release() }
            start()
        }
    }
}

class QuizViewModelFactory(private val soundManager: SoundManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuizViewModel(soundManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class QuizViewModel(private val soundManager: SoundManager): ViewModel() {
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

    private val _isLastAnswerCorrect = MutableLiveData<Boolean?>()
    val isLastAnswerCorrect: LiveData<Boolean?> = _isLastAnswerCorrect

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _currentDifficulty = MutableLiveData(Difficulty.Easy)
    val currentDifficulty: LiveData<Difficulty> = _currentDifficulty

    private val _userProgress = MutableLiveData(UserProgress.In_Progress)
    val userProgress: LiveData<UserProgress> = _userProgress

    val totalQuestions: Int
        get() = questionsRepository.getQuestions().size

    fun updateScore(newScore: Int) {
        _score.value = newScore
    }

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
        _userProgress.value = UserProgress.In_Progress
    }

    private fun checkProgressAndUpdate() {
        val totalQuestionsPerDifficulty = 4
        val correctAnswers = currentScore.value ?: 0

        val newProgress = when {
            correctAnswers >= totalQuestionsPerDifficulty * 3 -> UserProgress.Eco_Master
            correctAnswers >= totalQuestionsPerDifficulty * 2 -> UserProgress.Eco_Apprentice
            correctAnswers >= totalQuestionsPerDifficulty -> UserProgress.Eco_Novice
            else -> null
        }

        if (newProgress != null && newProgress != _userProgress.value) {
            _userProgress.value = newProgress
            soundManager.playCongratulationsSound()  // Play sound on progress change
        }
    }

    fun submitAnswer(answerIndex: Int) {
        val question = _currentQuestion.value ?: return
        val isCorrect = question.correctAnswerIndex == answerIndex

        _isLastAnswerCorrect.value = isCorrect
        _currentScore.value = (_currentScore.value ?: 0) + if (isCorrect) 1 else 0
        _selectedAnswerExplanation.value = question.explanation

        // Play sound based on whether the answer is correct
        if (isCorrect) {
            soundManager.playCorrectAnswerSound()
        } else {
            soundManager.playWrongAnswerSound()
        }

        checkProgressAndUpdate()
    }

    fun proceedToNextQuestion() {
        val nextIndex = (_currentQuestionIndex.value ?: 0) + 1
        if (nextIndex < (_questions.value?.size ?: 0)) {
            _currentQuestionIndex.value = nextIndex
            updateDifficultyIfNeeded()
        } else {
            _isGameOver.value = true
        }
    }
    private fun updateDifficultyIfNeeded() {
        val nextIndex = _currentQuestionIndex.value ?: 0
        val totalQuestionsPerDifficulty = 4 // Assuming 3 questions per difficulty level

        when {
            nextIndex >= totalQuestionsPerDifficulty * 2 -> _currentDifficulty.value = Difficulty.Hard
            nextIndex >= totalQuestionsPerDifficulty -> _currentDifficulty.value = Difficulty.Medium
            else -> _currentDifficulty.value = Difficulty.Easy
        }
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

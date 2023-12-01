package com.example.TechTusQuiz.Authentication

import com.example.TechTusQuiz.userProfile.UserProfile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthenticationRepo {
    val currentUser = FirebaseAuth.getInstance().currentUser

    fun hasUser(): Boolean = FirebaseAuth.getInstance().currentUser != null

    suspend fun login(username: String, password: String): Result<Boolean> = withContext(Dispatchers.IO) {
        try {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password).await()
            Result.success(true)
        } catch (e: FirebaseAuthException) {
            Result.failure(e)
        }
    }

    suspend fun saveUserProfile(userProfile: UserProfile) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        userId?.let {
            FirebaseDatabase.getInstance().getReference("Users")
                .child(userId)
                .setValue(userProfile).await()
        }
    }

    suspend fun getUserProfile(userId: String): UserProfile? {
        val databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        val dataSnapshot = databaseReference.child(userId).get().await()
        return dataSnapshot.getValue(UserProfile::class.java)
    }
}
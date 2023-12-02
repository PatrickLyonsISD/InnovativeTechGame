package com.example.TechTusQuiz.userProfile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


data class UserProfile(
    val email: String = "",
    val score: Int = 0
)

class UserProfileViewModel : ViewModel() {
    private val _userProfile = MutableStateFlow<UserProfile?>(null)
    val userProfile: StateFlow<UserProfile?> = _userProfile.asStateFlow()

    private val _statusMessage = MutableStateFlow<String?>(null)
    val statusMessage: StateFlow<String?> = _statusMessage.asStateFlow()

    init {
        fetchUserProfile()
    }

    fun addUserProfile(userId: String, email: String, score: Int) {
        val userProfile = UserProfile(email, score)
        FirebaseDatabase.getInstance().getReference("Users")
            .child(userId)
            .setValue(userProfile)
            .addOnSuccessListener {
                _statusMessage.value = "Profile updated successfully."
            }
            .addOnFailureListener { e ->
                _statusMessage.value = "Failed to update profile: ${e.message}"
            }
    }

    private fun fetchUserProfile() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            viewModelScope.launch {
                val databaseRef = FirebaseDatabase.getInstance().getReference("Users").child(userId)
                try {
                    val dataSnapshot = databaseRef.get().await()
                    if (dataSnapshot.exists()) {
                        val userProfile = dataSnapshot.getValue(UserProfile::class.java)
                        _userProfile.value = userProfile
                    } else {
                        Log.e("UserProfileVM", "User profile not found for user ID: $userId")
                    }
                } catch (e: Exception) {
                    Log.e("UserProfileVM", "Error fetching user profile", e)
                }
            }
        } else {
            Log.d("UserProfileVM", "No user logged in")
        }
    }

    fun enterDraw() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return

        val databaseRef = FirebaseDatabase.getInstance().getReference("winners")

        val winnerData = mapOf("email" to userEmail)

        databaseRef.child(userId).setValue(winnerData)
            .addOnSuccessListener {
                _statusMessage.value = "Successfully entered into the draw."
            }
            .addOnFailureListener {
                _statusMessage.value = "Failed to enter into the draw: ${it.message}"
            }
    }
}


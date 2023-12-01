package com.example.TechTusQuiz.SignUp

import androidx.lifecycle.ViewModel
import com.example.TechTusQuiz.userProfile.UserProfile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpViewModel : ViewModel() {
    fun signUp(email: String, password: String, name: String,  signUpMessage: (String) -> Unit) {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid
                    addUserProfileToDatabase(userId, UserProfile(name))
                    signUpMessage("Sign Up Successful!")
                } else {
                    signUpMessage("Sign Up Failed: ${task.exception?.message}")
                }
            }
    }

    private fun addUserProfileToDatabase(userId: String?, userProfile: UserProfile) {
        userId?.let { uid ->
            val databaseRef = FirebaseDatabase.getInstance().getReference("Users")
            databaseRef.child(uid).setValue(userProfile)
                .addOnSuccessListener {

                }
                .addOnFailureListener {

                }
        }
    }
}
package com.example.TechTusQuiz.SignUp

import androidx.lifecycle.ViewModel
import com.example.TechTusQuiz.userProfile.UserProfile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpViewModel : ViewModel() {

    fun signUp(email: String, password: String, kNumber: String, signUpMessage: (String) -> Unit) {
        if (!isEmailValid(email)) {
            signUpMessage("Invalid email address.")
            return
        }

        if (password.length < 6) {
            signUpMessage("Password must be at least 6 characters.")
            return
        }

        if (!kNumber.startsWith("k", ignoreCase = true)) {
            signUpMessage("K-number must start with 'k'.")
            return
        }

        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid
                    addUserProfileToDatabase(userId, UserProfile(kNumber))
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
                    // Handle success
                }
                .addOnFailureListener {
                    // Handle failure
                }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
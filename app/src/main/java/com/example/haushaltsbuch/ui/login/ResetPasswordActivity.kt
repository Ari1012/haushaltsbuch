package com.example.haushaltsbuch.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.haushaltsbuch.R
import com.example.haushaltsbuch.data.model.persons.Person
import com.example.haushaltsbuch.database.DBHelper
import com.example.haushaltsbuch.databinding.ActivityRegisterBinding
import com.example.haushaltsbuch.databinding.ActivityResetPasswordBinding
import java.util.*

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val emailButton = binding.button9

        emailButton.setOnClickListener {
            navigateToPassword()
        }
    }


    fun navigateToPassword() {
    }

    fun changePassword(view: View) {
        val email = binding.editTextTextEmailAddress2.toString()
        val password = binding.editTextTextEmailAddress2.toString()
        val databaseHandler: DBHelper = DBHelper()

        if (email.equals(databaseHandler.getUser(email))) {
            val status = databaseHandler.resetPassword(password)
            //after onClick
            binding.editTextTextEmailAddress2.clearComposingText()
        }
    }
}
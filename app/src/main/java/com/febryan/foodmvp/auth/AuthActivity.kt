package com.febryan.foodmvp.auth

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.febryan.foodmvp.R
import com.febryan.foodmvp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    var authPresenter: AuthPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActLogin.setOnClickListener {
            val email = binding.edtActLoginEmail.text.toString()
            val pw = binding.edtActLoginPassword.text.toString()
            authPresenter?.loginUser(email, pw)
        }

        binding.btnLogin.setOnClickListener {
            showFormLogin()
        }

        binding.btnRegister.setOnClickListener {
            showFormLRegister()
        }

    }

    private fun showFormLRegister() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.form_register)
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun showFormLogin() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.form_login)
        dialog.setCancelable(true)

        val edtEmail = dialog.findViewById<EditText>(R.id.edt_act_Login_email)
        val edtPw = dialog.findViewById<EditText>(R.id.edt_act_login_password)

        val btnLogin = dialog.findViewById<Button>(R.id.btn_act_login)

        btnLogin.setOnClickListener {

            val email = edtEmail.text.toString()
            val password = edtPw.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                Toast.makeText(this@AuthActivity, "Email and Password Required", Toast.LENGTH_SHORT).show()
            }else{
                authPresenter?.loginUser(email, password)
            }

        }

        dialog.show()
    }

    fun showMessage(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
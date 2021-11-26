package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern.compile

class RegistActivity : AppCompatActivity() {
    lateinit var  fname: EditText
    lateinit var  lname:EditText
    lateinit var  email:EditText
    lateinit var  password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        fname = findViewById(R.id.sign_name)
        lname = findViewById(R.id.sign_lastname)
        email = findViewById(R.id.sign_email)
        password = findViewById(R.id.sign_password)
    }

    fun back(view: android.view.View) {
        startActivity(Intent(this,LoginInActivity::class.java))
    }

    fun emailValid(email:String) : Boolean{
        return compile(Patterns.EMAIL_ADDRESS.pattern()).matcher(email).matches()
    }

    fun registr(view: android.view.View) {
        if (fname.text.isNotEmpty() &&
            lname.text.isNotEmpty() &&
            email.text.isNotEmpty() &&
            password.text.isNotEmpty()){
            if (emailValid(email.text.toString())){
                startActivity(Intent(this@RegistActivity,LoginInActivity::class.java))
            }
            else{
                AlertDialog.Builder(this)
                    .setTitle("Ошибка Email")
                    .setMessage("Поле email заполнено неверн")
                    .setPositiveButton("Ок",null)
                    .create()
                    .show()
            }
        }
        else{
            AlertDialog.Builder(this)
                .setTitle("Ошибка входа")
                .setMessage("У вас есть пустые поля")
                .setPositiveButton("Ок",null)
                .create()
                .show()
        }

    }
}
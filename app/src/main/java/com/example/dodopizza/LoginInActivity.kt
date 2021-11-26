package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.dodopizza.net.ApiRet
import com.example.dodopizza.net.Login
import com.example.dodopizza.net.MyRetrofit
import retrofit2.Call
import retrofit2.Response

class LoginInActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_in)
        email = findViewById(R.id.sign_email)
        password = findViewById(R.id.sign_password)
    }

    fun sign(view: android.view.View) {
        if (email.text.isNotEmpty() && password.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.text).matches()){
            val retrofit = MyRetrofit().getRetrofit().create(ApiRet::class.java)
            val hashMap: HashMap<String, String> = HashMap()
            hashMap["email"] = email.text.toString()
            hashMap["password"] = password.text.toString()

            val call: Call<Login> = retrofit.login(hashMap)
            call.enqueue(object: retrofit2.Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.body()?.token !=  0){
                        Login.userToken = response.body()?.token
                        Toast.makeText(this@LoginInActivity,"Успешно",Toast.LENGTH_SHORT).show()
                        //startActivity(Intent(this@SignInActivity, MainActivity::class.java))

                    }
                    else{
                        Toast.makeText(this@LoginInActivity,"Не удолось",Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Toast.makeText(this@LoginInActivity,t.message,Toast.LENGTH_LONG).show()
                }

        })
    }
}
    fun register(view: android.view.View) {
        startActivity(Intent(this@LoginInActivity,RegistActivity::class.java))
    }
}
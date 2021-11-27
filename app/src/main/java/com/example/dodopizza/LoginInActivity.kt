package com.example.dodopizza

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.dodopizza.net.ApiRet
import com.example.dodopizza.net.MyRetrofit
import com.example.dodopizza.net.User
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

            val call: Call<User> = retrofit.getUser(hashMap)
            call.enqueue(object: retrofit2.Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.body()?.id != null){
                        getSharedPreferences("user", Context.MODE_PRIVATE).edit()
                            .putString("id",response.body()?.id)
                            .putString("email",response.body()?.email)
                            .putString("nickName",response.body()?.nickName)
                            .putString("avatar",response.body()?.avatar)
                            .putString("token",response.body()?.token)
                            .apply()
                        Toast.makeText(this@LoginInActivity,"Успешно",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginInActivity, MainActivity::class.java))

                    }
                    else{
                       Toast.makeText(this@LoginInActivity,"Не удолось",Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@LoginInActivity,t.message,Toast.LENGTH_LONG).show()
                }

        })
    }
}
    fun register(view: android.view.View) {
        startActivity(Intent(this@LoginInActivity,RegistActivity::class.java))
    }
}
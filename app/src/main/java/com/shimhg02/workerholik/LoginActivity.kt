package com.shimhg02.workerholik


import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : BaseActivity() {
    val PREFERENCE = "com.shimhg02.worker"
    override var viewId: Int = R.layout.activity_login
    override var toolbarId: Int? = R.id.toolbar
    override fun onCreate() {

        login_btn.setOnClickListener {
            Client.retrofitService.logIn(id_tv.text.toString(), pw_tv.text.toString()).enqueue(object : Callback<Login> {
                override fun onResponse(call: Call<Login>?, response: Response<Login>?) {
                    when (response!!.code()) {
                        200 -> {

                            val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)
                            val editor = pref.edit()
                            editor.putString("token", response.body()!!.token.toString())
                            editor.putString("phone", response.body()!!.name.toString())
                            editor.putString("userName", response.body()!!.name.toString())
                            System.out.println("LOGD : " + response.body()!!.token.toString())
                            editor.apply()
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        }
                        404 ->          Toast.makeText(this@LoginActivity, "로그인 실패: PW나 ID를 다시 확인하세요.", Toast.LENGTH_LONG).show()//Toast.makeText(this@LoginActivity, "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show()
                        500 ->          Toast.makeText(this@LoginActivity, "서버에러", Toast.LENGTH_LONG).show()//Toast.makeText(this@LoginActivity, "로그인 실패 : 서버 오류", Toast.LENGTH_LONG).show()
                    }
                }


                override fun onFailure(call: Call<Login>?, t: Throwable?) {

                }


            })
        }

       signup_go.setOnClickListener { startActivity(Intent(this@LoginActivity, SignUpActivity::class.java)) }
    }

}
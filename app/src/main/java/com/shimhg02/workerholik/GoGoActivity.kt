package com.shimhg02.workerholik


import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gogogo.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GoGoActivity : BaseActivity() {
    override var viewId: Int = R.layout.activity_gogogo
    override var toolbarId: Int? = R.id.toolbar
    override fun onCreate() {
        gogogogo.setOnClickListener {
            val intent = Intent(this,ProgressActivity::class.java)
            startActivity(intent)
        }
    }

}
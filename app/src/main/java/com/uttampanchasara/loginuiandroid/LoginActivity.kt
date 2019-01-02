package com.uttampanchasara.loginuiandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtRegistration.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
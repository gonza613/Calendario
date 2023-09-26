package com.citigroup.calendario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnIngresar = findViewById<Button>(R.id.botonIngresar)
        btnIngresar.setOnClickListener {navigateToPrincipal()}

    }


    private fun navigateToPrincipal(){
        val intent = Intent(this, MainActivity:: class.java)
        startActivity(intent)
    }
}
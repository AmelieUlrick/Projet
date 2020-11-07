package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FormulaireConnexion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulaire_connexion)

        var login = findViewById<EditText>(R.id.connexion_login)
        var password = findViewById<EditText>(R.id.connexion_password)
        var connexion = findViewById<Button>(R.id.connexion)

        connexion.setOnClickListener {
            var intent = Intent(this, PagePrincipale::class.java)
            startActivity(intent)
        }

    }

}
package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FormulaireInscription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulaire_inscription)

        var nom = findViewById<EditText>(R.id.ed_nom)
        var prenom = findViewById<EditText>(R.id.ed_prenom)
        var password = findViewById<EditText>(R.id.ed_password)
        var btn_inscription = findViewById<Button>(R.id.confirmInscription)

        btn_inscription.setOnClickListener {
            val intent = Intent(this, PagePrincipale::class.java)
            startActivity(intent)
        }

    }

}
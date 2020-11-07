package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AjouterCarte : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_card)

        var nom = findViewById<EditText>(R.id.add_nom)
        var prenom = findViewById<EditText>(R.id.add_prenom)
        var carte = findViewById<EditText>(R.id.add_carte)
        var date = findViewById<EditText>(R.id.add_date)
        var btn_card = findViewById<Button>(R.id.add_card)

        btn_card.setOnClickListener {
            val intent = Intent(this, AfficheTest::class.java)
            startActivity(intent)
        }
    }
}
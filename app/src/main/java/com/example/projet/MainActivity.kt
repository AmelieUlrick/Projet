package com.example.projet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txt_bienvenue = findViewById<TextView>(R.id.bienvenue)
        var btn_inscription = findViewById<Button>(R.id.btn_creer)
        var btn_connexion = findViewById<Button>(R.id.btn_connexion)
        var calendar = findViewById<ImageView>(R.id.img_calendar)
        var money = findViewById<ImageView>(R.id.img_money)

        //declaration des animations
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb)
        txt_bienvenue.startAnimation(ttb)
        calendar.startAnimation(stb)
        money.startAnimation(stb)


        btn_inscription.setOnClickListener {
            val intent = Intent(this, FormulaireInscription::class.java)
            startActivity(intent)
        }

        btn_connexion.setOnClickListener {
            val intent = Intent(this,FormulaireConnexion::class.java)
            startActivity(intent)
        }
        }





}
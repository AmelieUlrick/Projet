package com.example.projet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.page.*

/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* var txt_bienvenue = findViewById<TextView>(R.id.bienvenue)
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
        }*/









        }





}*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page)
        val dbHandler = MindOrksDBOpenHelper(this, null)
        btnAddToDb.setOnClickListener {
            val dbHandler = MindOrksDBOpenHelper(this, null)
            val user = Name(etName.text.toString())
            dbHandler.addName(user)
            Toast.makeText(this, etName.text.toString() + "Added to database", Toast.LENGTH_LONG).show()
        }
        btnShowDatafromDb.setOnClickListener {
            tvDisplayName.text = ""
            val dbHandler = MindOrksDBOpenHelper(this, null)
            val cursor = dbHandler.getAllName()
            cursor!!.moveToFirst()
            tvDisplayName.append((cursor.getString(cursor.getColumnIndex(MindOrksDBOpenHelper.COLUMN_NAME))))
            while (cursor.moveToNext()) {
                tvDisplayName.append((cursor.getString(cursor.getColumnIndex(MindOrksDBOpenHelper.COLUMN_NAME))))
                tvDisplayName.append("\n")
            }
            cursor.close()
        }
        btn_read.setOnClickListener {
            var data = dbHandler.readData()
            tvResult.text = ""
            for(i in 0 until data.size){
                tvResult.append(data.get(i).id.toString() + " "+ data.get(i).userName + "\n")
            }
        }
        btn_delete.setOnClickListener {
            dbHandler.deleteData()
            btn_read.performClick()
        }
        /*btn_update.setOnClickListener {
            dbHandler.updateData()
            btn_read.performClick()
        }*/
        btn_page_connexion.setOnClickListener {
            val intent = Intent(this, PageConnexion::class.java)
            startActivity(intent)
        }
    }
}




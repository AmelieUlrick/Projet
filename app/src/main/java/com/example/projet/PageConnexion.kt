package com.example.projet

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.page.*
import kotlinx.android.synthetic.main.page_connexion.*

class PageConnexion : AppCompatActivity() {
    private lateinit var databaseHelper: MindOrksDBOpenHelper
    //val dbHandler = MindOrksDBOpenHelper(this, null)
    val editTextName = findViewById<EditText>(R.id.recup_name)
    val btn = findViewById<Button>(R.id.btn_test_connexion)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_connexion)


        btn.setOnClickListener {
            co()
        }

    }

       /* btn_test_connexion.setOnClickListener {
            val dbHandler = MindOrksDBOpenHelper(this, null)
            var recupName = Name(recup_name.getText().toString())
            var j = dbHandler.connexion(recupName)

            if(j != null){
                Toast.makeText(this, "succes",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"false",Toast.LENGTH_LONG).show()
            }
        }*/
      /* override fun onClick() {

        }*/
            private fun co() {
                if (databaseHelper!!.connexion(editTextName.text.toString().trim { it <= ' ' }))
                    Toast.makeText(this, "succes", Toast.LENGTH_LONG)
                else {
                    Toast.makeText(this, "false", Toast.LENGTH_LONG)
                }
            }



}

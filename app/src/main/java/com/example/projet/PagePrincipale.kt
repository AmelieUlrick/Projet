package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PagePrincipale : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_principale)

        var texte = findViewById<TextView>(R.id.msg_principale)
        var btn = findViewById<Button>(R.id.popup)

        btn.setOnClickListener {
            val pop = PopupMenu(this, btn)
            //Recupere le layout menu
            pop.inflate(R.menu.example_menu)
            pop.setOnMenuItemClickListener {item->
                when(item.itemId) {
                    R.id.add_card-> {
                        val intent = Intent(this, AjouterCarte::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.delete_card-> {
                        Toast.makeText(this, "Choisissez une carte a supprimer",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.affiche-> {
                        val intent = Intent(this, ListeImage::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
            pop.show()
        }

    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.example_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item1-> {
                Toast.makeText(this, "Item 1hduhsudbuqjsdb",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.item2-> {
                Toast.makeText(this, "Item 2",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item3-> {
                Toast.makeText(this, "Item 3",Toast.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }*/
}
package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class AfficheTest : AppCompatActivity() {

    internal lateinit var viewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.affiche_test)
        viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val adapter = ViewPageAdapter(this)
        viewPager.adapter = adapter



    }
}
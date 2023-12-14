package com.example.mncapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.res.AssetManager
import android.icu.util.IndianCalendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.util.*

class Mess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mess)

        //json parsing
        val jsonString = assets.readFile("mess.json")
        val messData = Gson().fromJson(jsonString, MessData::class.java)

        //recycler view
        val messRecycler = findViewById<RecyclerView>(R.id.messRecycler)
        messRecycler.layoutManager = LinearLayoutManager(this)
        messRecycler.adapter = MessAdapter(messData)

        //animation
        val resultItemAnim =
            LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.item_anim_2))
        resultItemAnim.delay = 0.40f
        resultItemAnim.order = LayoutAnimationController.ORDER_NORMAL
        messRecycler.layoutAnimation = resultItemAnim



    }


        private fun AssetManager.readFile(fileName: String) = open(fileName)
            .bufferedReader()
            .use { it.readText() }
    }
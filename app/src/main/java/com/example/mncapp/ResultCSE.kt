package com.example.mncapp

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ResultCSE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_cse)

        val jsonString = assets.readFile("cse_result.json")
        val resultData = Gson().fromJson(jsonString, ResultData::class.java)

        val resultRecycler = findViewById<RecyclerView>(R.id.resultCSERecycler)
        resultRecycler.layoutManager = LinearLayoutManager(this)
        resultRecycler.adapter = ResultAdapter(resultData)

        //animation
        val resultItemAnim = LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.item_anim))
        resultItemAnim.delay = 0.20f
        resultItemAnim.order = LayoutAnimationController.ORDER_NORMAL
        resultRecycler.layoutAnimation = resultItemAnim

    }

    private fun AssetManager.readFile(fileName: String) = open(fileName)
        .bufferedReader()
        .use { it.readText() }
}
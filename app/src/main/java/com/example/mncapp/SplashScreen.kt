package com.example.mncapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash_screen)

		//animation text
		val txtAnimation = AnimationUtils.loadAnimation(this, R.anim.splashtext_anim)
		txtApp.startAnimation(txtAnimation)

		//animation logo
		val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.icon_anim)
		imgLogo.startAnimation(logoAnimation)



		Handler(Looper.getMainLooper()).postDelayed({
			//goto main activity
			val i = Intent(this, MainActivity::class.java)
			startActivity(i)
			finish()
		}, 700)

	}
}
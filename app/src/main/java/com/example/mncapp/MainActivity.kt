package com.example.mncapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		//load username
		load_username()

		//animations
		username_animation()



//		button_animation(btnCSEResult)
//		button_animation(btnMnCResult)
//		button_animation(btnMess)

		//update username
		txtUserName.setOnClickListener {
			val i = Intent(this, UpdateName::class.java)
			startActivity(i)
		}


		if (Build.VERSION.SDK_INT >= 25) {
			Shortcuts.setUp(applicationContext)
		}

		btnMess.setOnClickListener {
			val i = Intent(this, Mess::class.java)
			startActivity(i)
		}

		btnCSEInfo.setOnClickListener {
			Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
		}

		btnCSEResult.setOnClickListener {
			val intent = Intent(this, ResultCSE::class.java)
			startActivity(intent)
		}

		btnMnCInfo.setOnClickListener {
			Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
		}

		btnMnCResult.setOnClickListener {
			val intent = Intent(this, Result::class.java)
			startActivity(intent)
		}
	}


//	private fun button_animation(btn: Button?) {
//		val anim = AnimationUtils.loadAnimation(this,R.anim.item_anim)
//		btn!!.startAnimation(anim)
//	}

	private fun username_animation() {
		val anim = AnimationUtils.loadAnimation(this,R.anim.username)
		txtUserName.startAnimation(anim)
	}

	private fun load_username() {
		val sharedPref = getSharedPreferences("USER_INFO", MODE_PRIVATE)

		//load username
		var username = sharedPref.getString("username", null)

		if (username == null) {
			username = "Vishal Singh"
		}

		//assign username
		txtUserName.text = username
	}

}

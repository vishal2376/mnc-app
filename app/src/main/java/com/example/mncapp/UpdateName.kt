package com.example.mncapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_name.*

class UpdateName : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_update_name)

		btnUpdateName.setOnClickListener {

			save_username()

			// goto main activity
			val i = Intent(this, MainActivity::class.java)
			startActivity(i)
			finish() //finish this activity
		}

	}

	private fun save_username() {
		val sharedPref = getSharedPreferences("USER_INFO", MODE_PRIVATE)
		val editor = sharedPref.edit()

		var inputUserName = editUserName.text.toString()
		//input should not be empty
		if (inputUserName.isEmpty()) {
			inputUserName = "Vishal Singh"
			Toast.makeText(this, "!!! EMPTY Name !!! , Pagal h kya #$@* ?", Toast.LENGTH_LONG).show()
		}

		editor.apply {
			putString("username", inputUserName)
		}.apply()

		Toast.makeText(this, "Name Changed to '$inputUserName'", Toast.LENGTH_SHORT).show()

	}
}
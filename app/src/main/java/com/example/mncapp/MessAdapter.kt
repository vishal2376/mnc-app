package com.example.mncapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mess_item.view.*
import java.util.*

class MessAdapter(val messData: MessData) : RecyclerView.Adapter<MessAdapter.MessViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.mess_item, parent, false)
		return MessViewHolder(view)


	}

	override fun onBindViewHolder(holder: MessViewHolder, position: Int) {

		//get day
		val day = Calendar.getInstance(TimeZone.getTimeZone("IST")).get(Calendar.DAY_OF_WEEK)

		//bg according to today
		if (position == day-1) {
			holder.messContainer.setBackgroundResource(R.drawable.bg_card_border)
		}

		holder.txtDay.text = messData.mess[position].day
		holder.txtBreakfast.text = messData.mess[position].food.breakfast
		holder.txtLunch.text = messData.mess[position].food.lunch
		holder.txtSnacks.text = messData.mess[position].food.snacks
		holder.txtDinner.text = messData.mess[position].food.dinner
	}

	override fun getItemCount(): Int {
		return messData.mess.size
	}

	class MessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		var txtDay = itemView.findViewById<TextView>(R.id.mDay)
		var txtBreakfast = itemView.findViewById<TextView>(R.id.mBreakfast)
		var txtLunch = itemView.findViewById<TextView>(R.id.mLunch)
		var txtSnacks = itemView.findViewById<TextView>(R.id.mSnacks)
		var txtDinner = itemView.findViewById<TextView>(R.id.mDinner)

		var messContainer = itemView.messContainer
	}
}
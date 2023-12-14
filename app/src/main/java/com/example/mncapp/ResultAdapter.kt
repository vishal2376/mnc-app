package com.example.mncapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(private val resultData:ResultData): RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_item,parent,false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.txtRoll.text = resultData.result[position].roll
        holder.txtName.text = resultData.result[position].name
        holder.txtCgpa.text = resultData.result[position].cgpa
    }

    override fun getItemCount(): Int {
        return resultData.result.size
    }


class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtRoll = itemView.findViewById<TextView>(R.id.rRoll)
    val txtName = itemView.findViewById<TextView>(R.id.rName)
    val txtCgpa = itemView.findViewById<TextView>(R.id.rCgpa)
}

}

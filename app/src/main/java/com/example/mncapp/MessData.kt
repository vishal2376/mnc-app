package com.example.mncapp

data class MessData(
    val mess: ArrayList<MessItem>
)

data class MessItem(
    val id: Int,
    val day: String,
    val food: Food
)

data class Food(
    val breakfast: String,
    val lunch: String,
    val snacks: String,
    val dinner: String
)

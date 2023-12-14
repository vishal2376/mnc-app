package com.example.mncapp

data class ResultData(
    val result: ArrayList<ResultItem>
)

data class ResultItem(
    val roll: String,
    val name: String,
    val cgpa: String
)
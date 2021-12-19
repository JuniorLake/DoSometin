package com.example.dosometin.model

data class Activity(
    val accessibility: Float,
    var activity: String,
    val key: String,
    val link: String,
    val participants: Int,
    val price: Float,
    val type: String,
    val error: String? = null
)
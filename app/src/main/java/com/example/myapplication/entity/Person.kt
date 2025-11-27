package com.example.myapplication.entity

import android.media.Image

data class Person(
    val id: Int,
    var name: String,
    var age: Int,
    var imageUri: String?
)
package com.example.routefinderke4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Route(
    val number: String,
    val origin: String,
    val destination: String,
    val stops: List<String>,
    val fare: String
) : Parcelable

package com.example.simbaseapp

data class DataPlan(
    val id : Int,
    val name : String,
    val currency : String,
    val day : Int,
    val mb : Double,
    val sms : Double,
    val smstodevice : Double,
    val countries : Int
)

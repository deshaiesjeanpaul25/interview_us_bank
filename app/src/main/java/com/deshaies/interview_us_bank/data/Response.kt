package com.deshaies.interview_us_bank.data

import com.google.gson.annotations.SerializedName


data class Response (

  @SerializedName("data"      ) var data      : ArrayList<Data> = arrayListOf(),
//  @SerializedName("timestamp" ) var timestamp : Int?            = null

)
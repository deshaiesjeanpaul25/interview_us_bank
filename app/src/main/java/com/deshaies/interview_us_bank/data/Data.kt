package com.deshaies.interview_us_bank.data

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("id"             ) var id             : String? = null,
  @SerializedName("symbol"         ) var symbol         : String? = null,
  @SerializedName("currencySymbol" ) var currencySymbol : String? = null,
  @SerializedName("type"           ) var type           : String? = null,
  @SerializedName("rateUsd"        ) var rateUsd        : String? = null

)
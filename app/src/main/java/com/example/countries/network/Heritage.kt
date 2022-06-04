package com.example.countries.network

import com.squareup.moshi.Json

data class Heritage (
    val nhits: String,
    val records: List<Records>

)

data class Records(
        @Json(name = "fields")
        val fields: Fields
    )

data class Fields(
        @Json(name = "name_en")
        val name: String? = "No Data",

        @Json(name = "short_description_en")
        val description: String? = "No Data",

        @Json(name = "country_en")
        val country: String? = "No Data"
)

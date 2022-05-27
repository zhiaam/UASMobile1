package com.example.countries.network

import com.squareup.moshi.Json

data class Country (
    @Json(name = "name")
    val name: Names?,

    @Json(name = "capital")
    val capital: List<String?> = listOf("None"),

    @Json(name = "region")
    val region: String? = "No Data",

    @Json(name = "flags")
    val flags: Flags?
)

data class Names(
    val common: String? = "No Data",
    val official: String? = "No Data"
)

data class Flags(
    val png: String? = "No Data",
    val svg: String? = "No Data"
)
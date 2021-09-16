package com.example.sundaymobilityassignment.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Countries(
    @SerializedName("Afghanistan")
    val afghanistan: List<Player>?,
    @SerializedName("Australia")
    val australia: List<Player>?,
    @SerializedName("Bangladesh")
    val bangladesh: List<Player>?,
    @SerializedName("England")
    val england: List<Player>?,
    @SerializedName("India")
    val india: List<Player>?,
    @SerializedName("New Zealand")
    val newZealand: List<Player>?,
    @SerializedName("Pakistan")
    val pakistan: List<Player>?,
    @SerializedName("South Africa")
    val southAfrica: List<Player>?,
    @SerializedName("Sri Lanka")
    val sriLanka: List<Player>?,
    @SerializedName("West Indies")
    val westIndies: List<Player>?,
)

data class Player(
    val name: String,
    val captain: Boolean = false,
) : Serializable {

    val lastName: String
        get() = try {
            (name.split(" ")[1])
        } catch (e: IndexOutOfBoundsException) {
            " "  // for players without last name
        }
}
package com.nyco.ghablame.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Foods(
    val username: String = "",
    //val foodDesc: String = "",
    //val foodsImage: String = ""
):Parcelable

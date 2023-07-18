package com.nyco.ghablame.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Foods(
    val username: String = "",
    val first_name: String = "",
    val last_name: String = "",
    val email: String = ""
):Parcelable

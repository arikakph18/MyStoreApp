package com.idn.arika.mystoreapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
            var name : String,
            var username : String,
            var photo : Int ,
            var like : String? = null  ,
            var follow : String? = null ,
            var company : String? = null ,
            var repository : String? = null ,
            var location : String? = null
    ) : Parcelable


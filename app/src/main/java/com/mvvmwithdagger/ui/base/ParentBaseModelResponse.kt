package com.mvvmwithdagger.ui.base

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
open class ParentBaseModelResponse(
    @field:SerializedName("message")
    @Expose
    val message: String? = null,

    @field:SerializedName("token")
    @Expose
    val token: String? = null,

//    @field:SerializedName("result")
//    @Expose
//    val result: String? = null,

    @field:SerializedName("status")
    @Expose
    val status: Boolean? = null
)
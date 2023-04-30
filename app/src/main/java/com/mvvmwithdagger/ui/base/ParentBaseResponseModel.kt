package com.mvvmwithdagger.ui.base

import com.google.gson.annotations.SerializedName

/**
 * Extentia
 * PUNE.
 */
open class ParentBaseResponseModel(
    @field:SerializedName("code")
    val code: Int?=null,
    @field:SerializedName("msg")
    val msg: String?=null,
    @field:SerializedName("message")
    val message: String?=null
)
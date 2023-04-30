package com.mvvmwithdagger.ui.base

import com.google.gson.annotations.SerializedName

/**
 * Extentia
 * PUNE.
 */
data class BaseResponseModel<P>(
    @field:SerializedName("result")
    val result: P?=null
): ParentBaseModelResponse()

data class BaseResponseModel2<P>(
    @field:SerializedName("result")
    val result: ArrayList<P>?=null
): ParentBaseModelResponse()

data class BaseResponseModel3<P>(
    @field:SerializedName("result")
    val data: List<P>?=null
): ParentBaseModelResponse()
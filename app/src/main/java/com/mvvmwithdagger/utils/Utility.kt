package com.mvvmwithdagger.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import com.akash.mvvmwithdagger.R


object Utility {

    private var canvas: Canvas? = null

    private var paint: Paint? = null

    private var bm: Bitmap? = null
    var width: Int = 0
    private var length = 0.0f

    private var bitbuf: ByteArray? = null

    fun showCommonProgressDialog(context: Context): Dialog {
        val views: View = LayoutInflater.from(context).inflate(R.layout.item_progress_bar, null)
        return Dialog(context).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setContentView(views)
            setCancelable(false)
        }
    }
}
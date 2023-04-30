package com.mvvmwithdagger.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class CommonUtils {

    fun LoadJSON(context : Context): String? {
        var json: String? = null
        json = try {
            val inputStream: InputStream = context.assets.open("jsons/country_code.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return json
    }
}
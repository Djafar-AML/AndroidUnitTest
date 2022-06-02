package com.example.unittest

import android.content.Context

class ComparedResource {


    fun isEqual(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}
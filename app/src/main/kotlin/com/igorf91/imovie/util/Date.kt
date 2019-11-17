package com.igorf91.imovie.util

import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatDate(): String {
    val local = Locale.getDefault()
    val parser = SimpleDateFormat("yyyy-MM-dd", local)
    val formatter = SimpleDateFormat("yyyy", local)
    val result = formatter.format(parser.parse(this)!!)
    return "($result)"
}
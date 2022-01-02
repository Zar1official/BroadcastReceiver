package zar1official.broadcastreceiver.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    const val formatPattern = "MM/dd/yyyy HH:mm"

    @SuppressLint("SimpleDateFormat")
    fun millisToDateTime(millis: Long): String =
        SimpleDateFormat(formatPattern).format(Date(millis))
}
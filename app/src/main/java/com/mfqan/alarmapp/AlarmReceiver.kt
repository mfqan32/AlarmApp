package com.mfqan.alarmapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {

    companion object {
        const val TYPE_ONE_TIME = 0
        const val TYPE_REPEATING = 1

        const val EXTRA_MESSAGE = "message"
        const val EXTRA_TYPE = "type"

        private const val ID_ONETIME = 100
        private const val ID_REPEATING = 101

        private const val DATE_FORMAT = "dd-MM-yyyy"
        private const val TIME_FORMAT = "HH:mm"
    }

    override fun onReceive(context: Context, intent: Intent) {

        val type = intent.getIntExtra(EXTRA_TYPE,0)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val title = if (type == TYPE_ONE_TIME) "One Time Alarm" else "Repeating Alarm"
        val notifId = if (type == TYPE_ONE_TIME) ID_ONETIME else ID_REPEATING

        if (message != null){
            showAlarmNotification(context, title, message ,notifId)
        }
    }

    private fun showAlarmNotification(
        context: Context,
        title: String,
        message: String,
        notifId: Int
    ) {


    }
}
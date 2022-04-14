package com.mfqan.alarmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mfqan.alarmapp.databinding.ActivityOneTimeAlarmBinding
import com.mfqan.alarmapp.fragment.DatePickerFragment
import com.mfqan.alarmapp.fragment.TimePickerFragment
import kotlinx.android.synthetic.main.activity_one_time_alarm.*
import java.text.SimpleDateFormat
import java.util.*

class OneTimeAlarmActivity : AppCompatActivity(), DatePickerFragment.DialogDateListener,
    TimePickerFragment.DialogTimeListener {

    private var binding: ActivityOneTimeAlarmBinding? = null

    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
        private const val TIME_PICKER_ONCE_TAG = "TimePickerOnce"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_time_alarm)


        btn_set_date_one_time.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG)
        }
        btn_set_time_one_time.setOnClickListener {
            val timePickerFragmentOneTime = TimePickerFragment()
            timePickerFragmentOneTime.show(supportFragmentManager, TIME_PICKER_ONCE_TAG)
        }
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val dateFormatOneTime = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

        tv_once_date.text = dateFormatOneTime.format(calendar.time)
    }

    override fun onDialogTimeSet(tag: String?, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)

        val timeFormatOneTime = SimpleDateFormat("HH:mm", Locale.getDefault())

        when (tag) {
            TIME_PICKER_ONCE_TAG -> tv_once_time.text = timeFormatOneTime.format(calendar.time)
            else -> {

            }
        }
    }
}
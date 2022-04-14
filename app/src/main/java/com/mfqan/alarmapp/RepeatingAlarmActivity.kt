package com.mfqan.alarmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mfqan.alarmapp.databinding.ActivityRepeatingAlarmBinding
import com.mfqan.alarmapp.fragment.TimePickerFragment
import kotlinx.android.synthetic.main.activity_repeating_alarm.*
import java.text.SimpleDateFormat
import java.util.*

class RepeatingAlarmActivity : AppCompatActivity(), TimePickerFragment.DialogTimeListener {

    private var binding: ActivityRepeatingAlarmBinding? = null

    companion object {
        private const val TIME_PICKER_REPEAT_TAG = "TimePickerRepeat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepeatingAlarmBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_repeating_alarm)


        btn_set_time_repeating.setOnClickListener {
            val timePickerFragmentRepeating = TimePickerFragment()
            timePickerFragmentRepeating.show(supportFragmentManager, TIME_PICKER_REPEAT_TAG)
        }

    }

    override fun onDialogTimeSet(tag: String?, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay)
        calendar.set(Calendar.MINUTE, minute)

        val timeFormatRepeating = SimpleDateFormat("HH:mm", Locale.getDefault())

        when(tag){
            TIME_PICKER_REPEAT_TAG -> binding?.tvRepeatingTime?.text = timeFormatRepeating.format(calendar.time)
            else -> {

            }
        }
    }


}
package com.example.hw_week4_day5

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerDolg:DialogFragment() {
    interface DatePickerCallback{
        fun  onDateSelected(date: Date)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val date = arguments?.getSerializable(TEXT_DATE_KEY) as Date

        val calendar = Calendar.getInstance()
        calendar?.time = date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datelistener = DatePickerDialog.OnDateSetListener {
                _, year, month, dayOfMonth ->
            val resultDate = GregorianCalendar(year, month, dayOfMonth).time
            targetFragment?.let {
                (it as DatePickerCallback).onDateSelected(resultDate)
            }
        }
        return DatePickerDialog(
            requireContext(),
            datelistener,
            year,
            month,
            day
        )
    }
}
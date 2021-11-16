package com.example.hw_week4_day5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*


const val TEXT_DATE_KEY="AB"
val format="EEE, yyyy MMM dd"
class Fragmebt_date_one:Fragment(),DatePickerDolg.DatePickerCallback {
    private lateinit var yourDateText: TextView
    private lateinit var datebton: Button

    private var date=Date()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragent_date_, container, false)
        yourDateText = view.findViewById(R.id.textView_Date)
        datebton = view.findViewById(R.id.date_botn)
        datebton.text = date.toString()
        return view
    }

    override fun onStart() {
        super.onStart()

        datebton.setOnClickListener {
            val args = Bundle()
            args.putSerializable(TEXT_DATE_KEY, date)
            val datePicker = DatePickerDolg()
            datePicker.arguments = args
            datePicker.setTargetFragment(this, 0)
            datePicker.show(this.parentFragmentManager, "data piker")
        }
    }

    override fun onDateSelected(date: Date) {
   yourDateText.text = date.toString()
    }
}

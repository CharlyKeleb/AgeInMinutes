package com.charlykeleb.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<View>(R.id.btnDatePicker) as Button

        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(
                    this,
                    "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth",
                    Toast.LENGTH_LONG
                ).show()
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                val tvSelectedDate = findViewById<View>(R.id.tvSelectedDate) as TextView
                val myAge = findViewById<View>(R.id.selectedDateInMinutes) as TextView
                tvSelectedDate.setText(selectedDate)
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val age = year - selectedYear
                val monthCalculate = age * 365
                val ageInMins = monthCalculate * 1440
                myAge.setText(ageInMins.toString())


            },
            year,
            month,
            day
        ).show()



    }
}
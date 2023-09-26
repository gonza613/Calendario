package com.citigroup.calendario.AgregarEvento

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.citigroup.calendario.R

class AgregarEvento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_evento)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Aquí obtienes la fecha seleccionada
            val selectedDate = "$dayOfMonth/${month + 1}/$year" // Formato: dd/MM/yyyy
            // Puedes mostrar esta fecha en un TextView o en otro lugar según tus necesidades
        }


        val seleccionNotificacionButton = findViewById<Button>(R.id.seleccionNotificacion)
        seleccionNotificacionButton.setOnClickListener { view ->
            val popupMenu = PopupMenu(this@AgregarEvento, view)
            popupMenu.menuInflater.inflate(R.menu.notification_menu, popupMenu.menu)

            // Manejar la selección de elementos del menú
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.one_day_before -> {
                        true
                    }
                    R.id.two_days_before -> {
                        true
                    }
                    R.id.three_days_before -> {
                        true

                    }
                    R.id.four_days_before -> {
                        true
                    }
                    R.id.five_days_before -> {
                        true
                    }
                    R.id.six_days_before -> {
                        true
                    }
                    R.id.seven_days_before -> {
                        true
                    }
                    R.id.selected_days_before -> {
                        true
                    }







                    else -> false
                }
            }

            popupMenu.show()
        }
    }
}

package com.citigroup.calendario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.citigroup.calendario.AgregarEvento.AgregarEvento
import com.citigroup.calendario.AgregarEvento.Inscripcion
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAgregar = findViewById<Button>(R.id.botonAgregar)
        btnAgregar.setOnClickListener {navigateToAddEvent()}

        val btnInscripcion = findViewById<Button>(R.id.inscripcion)
        btnInscripcion.setOnClickListener{navigateToInscripcion()}

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, 2023)
        calendar.set(Calendar.MONTH, Calendar.OCTOBER)
        calendar.set(Calendar.DAY_OF_MONTH, 24)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        val fechaEspecialMillis = calendar.timeInMillis

        val fechaEspecial: Long = fechaEspecialMillis

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        // Configura un oyente para manejar la selección de fecha
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = "$year-${month + 1}-$dayOfMonth"
            fun getDateMillis(year: Int, month: Int, dayOfMonth: Int): Long {
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)
                return calendar.timeInMillis
            }
            calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                val selectedDateMillis = getDateMillis(year, month, dayOfMonth)

                if (selectedDateMillis == fechaEspecial) {
                    // Cambia el fondo de la fecha especial a rojo
                    val dateViewId = resources.getIdentifier("date", "id", "android")
                    val dateView = view.findViewById<CalendarView>(dateViewId)
                    dateView.setBackgroundColor(2)
                }
                Toast.makeText(this, "Fecha seleccionada: $selectedDate", Toast.LENGTH_SHORT).show()
            }
        }

        val calendarView1 = findViewById<CalendarView>(R.id.calendarView)
        val calendar1 = Calendar.getInstance()
        calendar1.set(2023, Calendar.OCTOBER, 24) // Ajusta la fecha del evento
        val dateInMillis1 = calendar.timeInMillis
        calendarView1.setDate(dateInMillis1)

    }

    private fun navigateToAddEvent(){
        val intent = Intent(this, AgregarEvento:: class.java)
        startActivity(intent)
    }

    private fun navigateToInscripcion(){
        val intent = Intent(this, Inscripcion:: class.java)
        startActivity(intent)
    }

}

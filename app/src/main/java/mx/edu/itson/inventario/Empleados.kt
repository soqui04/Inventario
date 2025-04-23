package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EmpleadosActivity : AppCompatActivity() {

    private val empleados = mutableListOf("Laura Ramírez", "Sergio Torres")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados)

        val lista = findViewById<ListView>(R.id.listaEmpleados)
        val btnAgregar = findViewById<Button>(R.id.btnAgregarEmpleado)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, empleados)
        lista.adapter = adapter

        btnAgregar.setOnClickListener {
            empleados.add("Nuevo Empleado")
            adapter.notifyDataSetChanged()
        }
    }
}

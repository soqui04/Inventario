package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AgregarClienteActivity : AppCompatActivity() {

    private lateinit var etNombreCliente: EditText
    private lateinit var etDireccion: EditText
    private lateinit var etTelefonoCliente: EditText
    private lateinit var btnGuardarCliente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

        etNombreCliente = findViewById(R.id.etNombreCliente)
        etDireccion = findViewById(R.id.etDireccion)
        etTelefonoCliente = findViewById(R.id.etTelefonoCliente)
        btnGuardarCliente = findViewById(R.id.btnGuardarCliente)

        btnGuardarCliente.setOnClickListener {
            val nombre = etNombreCliente.text.toString()
            val direccion = etDireccion.text.toString()
            val telefono = etTelefonoCliente.text.toString()

            if (nombre.isNotEmpty() && direccion.isNotEmpty() && telefono.isNotEmpty()) {
                Toast.makeText(this, "Cliente agregado", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
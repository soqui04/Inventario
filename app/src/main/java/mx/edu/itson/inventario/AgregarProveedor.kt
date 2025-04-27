package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AgregarProveedorActivity : AppCompatActivity() {

    private lateinit var etNombreProveedor: EditText
    private lateinit var etEmpresa: EditText
    private lateinit var etTelefonoProveedor: EditText
    private lateinit var btnGuardarProveedor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_proveedor)

        etNombreProveedor = findViewById(R.id.etNombreProveedor)
        etEmpresa = findViewById(R.id.etEmpresa)
        etTelefonoProveedor = findViewById(R.id.etTelefonoProveedor)
        btnGuardarProveedor = findViewById(R.id.btnGuardarProveedor)

        btnGuardarProveedor.setOnClickListener {
            val nombre = etNombreProveedor.text.toString()
            val empresa = etEmpresa.text.toString()
            val telefono = etTelefonoProveedor.text.toString()

            if (nombre.isNotEmpty() && empresa.isNotEmpty() && telefono.isNotEmpty()) {
                Toast.makeText(this, "Proveedor agregado", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
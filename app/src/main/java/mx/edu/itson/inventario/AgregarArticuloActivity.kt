package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AgregarArticuloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_articulo)

        val etNombre = findViewById<EditText>(R.id.etNombreArticulo)
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val etCategoria = findViewById<EditText>(R.id.etCategoria)
        val etDescripcion = findViewById<EditText>(R.id.etDescripcion)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarArticulo)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val cantidad = etCantidad.text.toString()
            val categoria = etCategoria.text.toString()

            if (nombre.isBlank() || cantidad.isBlank() || categoria.isBlank()) {
                Toast.makeText(this, "Completa los campos obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Artículo guardado (simulado)", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }
}

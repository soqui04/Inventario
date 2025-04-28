package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
class AgregarArticuloActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_articulo)

        val etNombre = findViewById<EditText>(R.id.etNombreArticulo)
        val etDescripcion = findViewById<EditText>(R.id.etDescripcion)
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val btnAgregar = findViewById<Button>(R.id.btnGuardarArticulo)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val descripcion = etDescripcion.text.toString()
            val cantidadTexto = etCantidad.text.toString()

            if (nombre.isBlank() || descripcion.isBlank() || cantidadTexto.isBlank()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val cantidad = cantidadTexto.toIntOrNull()

                if (cantidad == null || cantidad < 0) {
                    Toast.makeText(this, "Cantidad inválida", Toast.LENGTH_SHORT).show()
                } else {
                    val articulo = hashMapOf(
                        "nombre" to nombre,
                        "descripcion" to descripcion,
                        "cantidad" to cantidad
                    )

                    db.collection("articulo")
                        .add(articulo)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Artículo agregado correctamente", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error al agregar artículo", Toast.LENGTH_SHORT).show()
                        }
                }
            }
        }
    }
}
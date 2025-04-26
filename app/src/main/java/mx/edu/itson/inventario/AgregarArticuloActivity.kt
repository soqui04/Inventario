package mx.edu.itson.inventario

import android.os.Bundle
<<<<<<< HEAD
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
=======
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
>>>>>>> 264c246 (database first changes)

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
<<<<<<< HEAD
            val nombre = etNombre.text.toString()
            val cantidad = etCantidad.text.toString()
            val categoria = etCategoria.text.toString()

            if (nombre.isBlank() || cantidad.isBlank() || categoria.isBlank()) {
                Toast.makeText(this, "Completa los campos obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Artículo guardado (simulado)", Toast.LENGTH_SHORT).show()
                finish()
=======
            val nombre = etNombre.text.toString().trim()
            val cantidadTexto = etCantidad.text.toString().trim()
            val categoriaTexto = etCategoria.text.toString().trim().lowercase()
            val descripcion = etDescripcion.text.toString().trim()

            if (nombre.isBlank() || cantidadTexto.isBlank() || categoriaTexto.isBlank()) {
                Toast.makeText(this, "Completa los campos obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                val cantidad = cantidadTexto.toIntOrNull() ?: 0
                if (cantidad == 0) {
                    Toast.makeText(this, "Cantidad inválida", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val db = FirebaseFirestore.getInstance()

                db.collection("categoria")
                    .whereEqualTo("nombre", categoriaTexto)
                    .get()
                    .addOnSuccessListener { querySnapshot ->
                        if (!querySnapshot.isEmpty) {

                            val categoriaDoc = querySnapshot.documents[0].reference

                            val articulo = mapOf(
                                "nombre" to nombre,
                                "descripcion" to descripcion,
                                "cantidad" to cantidad,
                                "categoria" to categoriaDoc
                            )

                            db.collection("articulo")
                                .add(articulo)
                                .addOnSuccessListener { documentReference ->
                                    Log.d("Firestore", "Artículo agregado con ID: ${documentReference.id}")
                                    Toast.makeText(this, "Artículo guardado correctamente", Toast.LENGTH_SHORT).show()
                                    finish()
                                }
                                .addOnFailureListener { e ->
                                    Log.e("Firestore", "Error al guardar artículo", e)
                                    Toast.makeText(this, "Error al guardar artículo", Toast.LENGTH_SHORT).show()
                                }
                        } else {
                            Toast.makeText(this, "Error: la categoría no existe", Toast.LENGTH_LONG).show()
                        }
                    }
                    .addOnFailureListener { e ->
                        Log.e("Firestore", "Error al buscar categoría", e)
                        Toast.makeText(this, "Error al buscar categoría", Toast.LENGTH_SHORT).show()
                    }
>>>>>>> 264c246 (database first changes)
            }
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }
}

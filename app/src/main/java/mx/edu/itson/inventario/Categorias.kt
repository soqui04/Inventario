package mx.edu.itson.inventario

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class CategoriasActivity : AppCompatActivity() {

    private lateinit var listaCategorias: ListView
    private lateinit var btnAgregarCategoria: Button
    private lateinit var adaptador: ArrayAdapter<String>
    private val categorias = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        listaCategorias = findViewById(R.id.listaCategorias)
        btnAgregarCategoria = findViewById(R.id.btnAgregarCategoria)

        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, categorias)
        listaCategorias.adapter = adaptador

        cargarCategoriasDesdeFirestore()

        btnAgregarCategoria.setOnClickListener {
            val input = EditText(this)
            input.hint = "Ej. Juguetes - Rojo"

            AlertDialog.Builder(this)
                .setTitle("Nueva categoría")
                .setView(input)
                .setPositiveButton("Agregar") { _, _ ->
                    val texto = input.text.toString()
                    if (texto.isNotBlank()) {
                        agregarCategoriaAFirestore(texto)
                    } else {
                        Toast.makeText(this, "No se agregó ninguna categoría", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        listaCategorias.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Categoría: ${categorias[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarCategoriasDesdeFirestore() {
        val db = FirebaseFirestore.getInstance()

        db.collection("categoria")
            .get()
            .addOnSuccessListener { result ->
                categorias.clear()
                for (document in result) {
                    val nombre = document.getString("nombre")
                    if (!nombre.isNullOrEmpty()) {
                        categorias.add(nombre)
                    }
                }
                adaptador.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error al cargar categorías", e)
                Toast.makeText(this, "Error al cargar categorías", Toast.LENGTH_SHORT).show()
            }
    }

    private fun agregarCategoriaAFirestore(nombreCategoria: String) {
        val db = FirebaseFirestore.getInstance()

        val categoria = mapOf(
            "nombre" to nombreCategoria
        )

        db.collection("categoria")
            .add(categoria)
            .addOnSuccessListener {
                Log.d("Firestore", "Categoría agregada correctamente")
                categorias.add(nombreCategoria)
                adaptador.notifyDataSetChanged()
                Toast.makeText(this, "Categoría agregada", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error al agregar categoría", e)
                Toast.makeText(this, "Error al agregar categoría", Toast.LENGTH_SHORT).show()
            }
    }
}

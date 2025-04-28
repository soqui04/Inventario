package mx.edu.itson.inventario

import android.os.Bundle
<<<<<<< HEAD
=======
<<<<<<< HEAD
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
<<<<<<< HEAD

=======
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
class CategoriasActivity : AppCompatActivity() {

    private lateinit var listaCategorias: ListView
    private lateinit var btnAgregarCategoria: Button
<<<<<<< HEAD
    private lateinit var adaptador: ArrayAdapter<String>
    private val categorias = mutableListOf<String>()
=======
<<<<<<< HEAD
    private val categorias = mutableListOf("Ropa - Azul", "Electrónica - Verde", "Papelería - Amarillo")
=======
    private lateinit var adaptador: ArrayAdapter<String>
    private val categorias = mutableListOf<String>()
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        listaCategorias = findViewById(R.id.listaCategorias)
        btnAgregarCategoria = findViewById(R.id.btnAgregarCategoria)

<<<<<<< HEAD
=======
<<<<<<< HEAD
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, categorias)
        listaCategorias.adapter = adaptador

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, categorias)
        listaCategorias.adapter = adaptador

        cargarCategoriasDesdeFirestore()

<<<<<<< HEAD
=======
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        btnAgregarCategoria.setOnClickListener {
            val input = EditText(this)
            input.hint = "Ej. Juguetes - Rojo"

            AlertDialog.Builder(this)
                .setTitle("Nueva categoría")
                .setView(input)
                .setPositiveButton("Agregar") { _, _ ->
                    val texto = input.text.toString()
                    if (texto.isNotBlank()) {
<<<<<<< HEAD
                        agregarCategoriaAFirestore(texto)
=======
<<<<<<< HEAD
                        categorias.add(texto)
                        adaptador.notifyDataSetChanged()
                        Toast.makeText(this, "Categoría agregada", Toast.LENGTH_SHORT).show()
=======
                        agregarCategoriaAFirestore(texto)
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
}
=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

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
<<<<<<< HEAD
=======
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

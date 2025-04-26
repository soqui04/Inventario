package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
=======
import android.util.Log
>>>>>>> 264c246 (database first changes)
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
=======
import com.google.firebase.firestore.FirebaseFirestore
>>>>>>> 264c246 (database first changes)

class ArticulosActivity : AppCompatActivity() {

    private lateinit var listaArticulos: ListView
    private lateinit var btnAgregarArticulo: Button
<<<<<<< HEAD
=======
    private lateinit var adaptador: ArrayAdapter<String>
    private var listaArticulosData = mutableListOf<String>()
>>>>>>> 264c246 (database first changes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulos)

        listaArticulos = findViewById(R.id.listaArticulos)
        btnAgregarArticulo = findViewById(R.id.btnAgregarArticulo)

<<<<<<< HEAD
        val articulosEjemplo = listOf(
            "Camiseta - Talla M - $150",
            "Zapatos - Talla 26 - $700",
            "Pantalón - Talla 32 - $300"
        )

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, articulosEjemplo)
        listaArticulos.adapter = adaptador

=======
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaArticulosData)
        listaArticulos.adapter = adaptador

        cargarArticulosDesdeFirestore()

>>>>>>> 264c246 (database first changes)
        btnAgregarArticulo.setOnClickListener {
            val intent = Intent(this, AgregarArticuloActivity::class.java)
            startActivity(intent)
        }

        listaArticulos.setOnItemClickListener { _, _, position, _ ->
<<<<<<< HEAD
            val articulo = articulosEjemplo[position]
            val intent = Intent(this, DetalleArticuloActivity::class.java)
            intent.putExtra("nombre", articulo)
            intent.putExtra("cantidad", "10") // Simulado
            intent.putExtra("categoria", "Ropa") // Simulado
            intent.putExtra("descripcion", "Ejemplo de descripción") // Simulado
            startActivity(intent)
        }
    }
=======
            val articuloTexto = listaArticulosData[position]
            val partes = articuloTexto.split(" - ")

            val nombre = partes.getOrNull(0) ?: "Sin nombre"
            val cantidad = partes.getOrNull(1) ?: "Sin cantidad"
            val categoria = partes.getOrNull(2) ?: "Sin categoría"

            val intent = Intent(this, DetalleArticuloActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("cantidad", cantidad)
            intent.putExtra("categoria", categoria)
            intent.putExtra("descripcion", "Descripción no disponible") // Opcional
            startActivity(intent)
        }
    }

    private fun cargarArticulosDesdeFirestore() {
        val db = FirebaseFirestore.getInstance()

        db.collection("articulo")
            .get()
            .addOnSuccessListener { querySnapshot ->
                listaArticulosData.clear()

                for (document in querySnapshot) {
                    val nombre = document.getString("nombre") ?: "Sin nombre"
                    val cantidad = document.getLong("cantidad")?.toString() ?: "0"

                   // val categoria = "Categoría"

                    val texto = "$nombre - $cantidad"
                    //   val texto = "$nombre - $cantidad - $categoria"
                    listaArticulosData.add(texto)
                }

                adaptador.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error al cargar artículos", e)
                Toast.makeText(this, "Error al cargar artículos", Toast.LENGTH_SHORT).show()
            }
    }
>>>>>>> 264c246 (database first changes)
}

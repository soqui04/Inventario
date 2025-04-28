package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.util.Log
=======
<<<<<<< HEAD
=======
import android.util.Log
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import com.google.firebase.firestore.FirebaseFirestore
=======
<<<<<<< HEAD
=======
import com.google.firebase.firestore.FirebaseFirestore
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

class ArticulosActivity : AppCompatActivity() {

    private lateinit var listaArticulos: ListView
    private lateinit var btnAgregarArticulo: Button
<<<<<<< HEAD
    private lateinit var adaptador: ArrayAdapter<String>
    private var listaArticulosData = mutableListOf<String>()
=======
<<<<<<< HEAD
=======
    private lateinit var adaptador: ArrayAdapter<String>
    private var listaArticulosData = mutableListOf<String>()
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulos)

        listaArticulos = findViewById(R.id.listaArticulos)
        btnAgregarArticulo = findViewById(R.id.btnAgregarArticulo)

<<<<<<< HEAD
=======
<<<<<<< HEAD
        val articulosEjemplo = listOf(
            "Camiseta - Talla M - $150",
            "Zapatos - Talla 26 - $700",
            "Pantalón - Talla 32 - $300"
        )

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, articulosEjemplo)
        listaArticulos.adapter = adaptador

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaArticulosData)
        listaArticulos.adapter = adaptador

        cargarArticulosDesdeFirestore()

<<<<<<< HEAD
=======
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        btnAgregarArticulo.setOnClickListener {
            val intent = Intent(this, AgregarArticuloActivity::class.java)
            startActivity(intent)
        }

        listaArticulos.setOnItemClickListener { _, _, position, _ ->
<<<<<<< HEAD
=======
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
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            val articuloTexto = listaArticulosData[position]
            val partes = articuloTexto.split(" - ")

            val nombre = partes.getOrNull(0) ?: "Sin nombre"
            val cantidad = partes.getOrNull(1) ?: "Sin cantidad"
<<<<<<< HEAD
=======
            val categoria = partes.getOrNull(2) ?: "Sin categoría"
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

            val intent = Intent(this, DetalleArticuloActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("cantidad", cantidad)
<<<<<<< HEAD
            intent.putExtra("descripcion", "Descripción no disponible") // Aquí luego podrías cargar una descripción real
=======
            intent.putExtra("categoria", categoria)
            intent.putExtra("descripcion", "Descripción no disponible") // Opcional
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
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

<<<<<<< HEAD
                    val texto = "$nombre - $cantidad"
=======
                   // val categoria = "Categoría"

                    val texto = "$nombre - $cantidad"
                    //   val texto = "$nombre - $cantidad - $categoria"
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
                    listaArticulosData.add(texto)
                }

                adaptador.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error al cargar artículos", e)
                Toast.makeText(this, "Error al cargar artículos", Toast.LENGTH_SHORT).show()
            }
    }
<<<<<<< HEAD
=======
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
}

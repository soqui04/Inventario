package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class ArticulosActivity : AppCompatActivity() {

    private lateinit var listaArticulos: ListView
    private lateinit var btnAgregarArticulo: Button
    private lateinit var adaptador: ArrayAdapter<String>
    private var listaArticulosData = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulos)

        listaArticulos = findViewById(R.id.listaArticulos)
        btnAgregarArticulo = findViewById(R.id.btnAgregarArticulo)

        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaArticulosData)
        listaArticulos.adapter = adaptador

        cargarArticulosDesdeFirestore()

        btnAgregarArticulo.setOnClickListener {
            val intent = Intent(this, AgregarArticuloActivity::class.java)
            startActivity(intent)
        }

        listaArticulos.setOnItemClickListener { _, _, position, _ ->
            val articuloTexto = listaArticulosData[position]
            val partes = articuloTexto.split(" - ")

            val nombre = partes.getOrNull(0) ?: "Sin nombre"
            val cantidad = partes.getOrNull(1) ?: "Sin cantidad"

            val intent = Intent(this, DetalleArticuloActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("cantidad", cantidad)
            intent.putExtra("descripcion", "Descripción no disponible") // Aquí luego podrías cargar una descripción real
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

                    val texto = "$nombre - $cantidad"
                    listaArticulosData.add(texto)
                }

                adaptador.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error al cargar artículos", e)
                Toast.makeText(this, "Error al cargar artículos", Toast.LENGTH_SHORT).show()
            }
    }
}

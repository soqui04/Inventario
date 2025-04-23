package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ArticulosActivity : AppCompatActivity() {

    private lateinit var listaArticulos: ListView
    private lateinit var btnAgregarArticulo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulos)

        listaArticulos = findViewById(R.id.listaArticulos)
        btnAgregarArticulo = findViewById(R.id.btnAgregarArticulo)

        val articulosEjemplo = listOf(
            "Camiseta - Talla M - $150",
            "Zapatos - Talla 26 - $700",
            "Pantalón - Talla 32 - $300"
        )

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, articulosEjemplo)
        listaArticulos.adapter = adaptador

        btnAgregarArticulo.setOnClickListener {
            val intent = Intent(this, AgregarArticuloActivity::class.java)
            startActivity(intent)
        }

        listaArticulos.setOnItemClickListener { _, _, position, _ ->
            val articulo = articulosEjemplo[position]
            val intent = Intent(this, DetalleArticuloActivity::class.java)
            intent.putExtra("nombre", articulo)
            intent.putExtra("cantidad", "10") // Simulado
            intent.putExtra("categoria", "Ropa") // Simulado
            intent.putExtra("descripcion", "Ejemplo de descripción") // Simulado
            startActivity(intent)
        }
    }
}

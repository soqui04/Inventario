package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetalleArticuloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_articulo)

        val tvNombre = findViewById<TextView>(R.id.tvNombreArticulo)
        val tvCantidad = findViewById<TextView>(R.id.tvCantidadArticulo)
        val tvCategoria = findViewById<TextView>(R.id.tvCategoriaArticulo)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcionArticulo)
        val btnEditar = findViewById<Button>(R.id.btnEditar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)

        // Simulación: obtener datos desde intent
        val nombre = intent.getStringExtra("nombre")
        val cantidad = intent.getStringExtra("cantidad")
        val categoria = intent.getStringExtra("categoria")
        val descripcion = intent.getStringExtra("descripcion")

        tvNombre.text = "Nombre: $nombre"
        tvCantidad.text = "Cantidad: $cantidad"
        tvCategoria.text = "Categoría: $categoria"
        tvDescripcion.text = "Descripción: ${descripcion ?: "N/A"}"

        btnEditar.setOnClickListener {
            Toast.makeText(this, "Función editar aún no implementada", Toast.LENGTH_SHORT).show()
        }

        btnEliminar.setOnClickListener {
            Toast.makeText(this, "Función eliminar aún no implementada", Toast.LENGTH_SHORT).show()
        }
    }
}

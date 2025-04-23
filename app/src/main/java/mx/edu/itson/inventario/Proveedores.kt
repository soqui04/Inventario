package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProveedoresActivity : AppCompatActivity() {

    private val proveedores = mutableListOf("Distribuidora A", "Proveedora B")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proveedores)

        val lista = findViewById<ListView>(R.id.listaProveedores)
        val btnAgregar = findViewById<Button>(R.id.btnAgregarProveedor)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, proveedores)
        lista.adapter = adapter

        btnAgregar.setOnClickListener {
            proveedores.add("Nuevo Proveedor")
            adapter.notifyDataSetChanged()
        }
    }
}

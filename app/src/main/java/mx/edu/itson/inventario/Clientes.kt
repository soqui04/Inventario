package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ClientesActivity : AppCompatActivity() {

    private val clientes = mutableListOf("Juan Pérez", "María Gómez", "Carlos Díaz")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)

        val lista = findViewById<ListView>(R.id.listaClientes)
        val btnAgregar = findViewById<Button>(R.id.btnAgregarCliente)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, clientes)
        lista.adapter = adapter

        btnAgregar.setOnClickListener {
            clientes.add("Nuevo Cliente")
            adapter.notifyDataSetChanged()
        }
    }
}

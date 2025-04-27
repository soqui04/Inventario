package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ClientesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)

        val btnAgregarCliente = findViewById<Button>(R.id.btnAgregarCliente)

        // Al hacer click, abre el formulario para agregar un cliente
        btnAgregarCliente.setOnClickListener {
            startActivity(Intent(this, AgregarClienteActivity::class.java))
        }
    }
}

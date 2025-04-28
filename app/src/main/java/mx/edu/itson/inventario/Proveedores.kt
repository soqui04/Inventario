package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProveedoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proveedores)

        val btnAgregarProveedor = findViewById<Button>(R.id.btnAgregarProveedor)

        // Al hacer click, abre el formulario para agregar un proveedor
        btnAgregarProveedor.setOnClickListener {
            startActivity(Intent(this, AgregarProveedorActivity::class.java))
        }
    }
}

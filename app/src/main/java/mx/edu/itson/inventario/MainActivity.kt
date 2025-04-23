package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnArticulos = findViewById<Button>(R.id.btnArticulos)
        val btnCategorias = findViewById<Button>(R.id.btnCategorias)
        val btnProveedores = findViewById<Button>(R.id.btnProveedores)
        val btnClientes = findViewById<Button>(R.id.btnClientes)
        val btnEmpleados = findViewById<Button>(R.id.btnEmpleados)
        val btnMovimientos = findViewById<Button>(R.id.btnMovimientos)
        val btnReporte = findViewById<Button>(R.id.btnReporte)
        val btnConfiguracion = findViewById<Button>(R.id.btnConfiguracion)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)

        btnArticulos.setOnClickListener {
            startActivity(Intent(this, ArticulosActivity::class.java))
        }

        btnCategorias.setOnClickListener {
            startActivity(Intent(this, CategoriasActivity::class.java))
        }

        btnProveedores.setOnClickListener {
            startActivity(Intent(this, ProveedoresActivity::class.java))
        }

        btnClientes.setOnClickListener {
            startActivity(Intent(this, ClientesActivity::class.java))
        }

        btnEmpleados.setOnClickListener {
            startActivity(Intent(this, EmpleadosActivity::class.java))
        }

        btnMovimientos.setOnClickListener {
            startActivity(Intent(this, MovimientosActivity::class.java))
        }

        btnReporte.setOnClickListener {
            startActivity(Intent(this, ReporteActivity::class.java))
        }

        btnConfiguracion.setOnClickListener {
            startActivity(Intent(this, ConfiguracionActivity::class.java))
        }

        btnCerrarSesion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}

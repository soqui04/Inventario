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

        // Abrir actividad de Artículos
        btnArticulos.setOnClickListener {
            startActivity(Intent(this, ArticulosActivity::class.java))
        }

        // Abrir actividad de Categorías
        btnCategorias.setOnClickListener {
            startActivity(Intent(this, CategoriasActivity::class.java))
        }

        // Abrir actividad de Proveedores
        btnProveedores.setOnClickListener {
            startActivity(Intent(this, ProveedoresActivity::class.java))
        }

        // Abrir actividad de Clientes
        btnClientes.setOnClickListener {
            startActivity(Intent(this, ClientesActivity::class.java))
        }

        // Abrir actividad de Empleados
        btnEmpleados.setOnClickListener {
            startActivity(Intent(this, EmpleadosActivity::class.java))
        }

        // Abrir actividad de Movimientos
        btnMovimientos.setOnClickListener {
            startActivity(Intent(this, MovimientosActivity::class.java))
        }

        // Abrir actividad de Reportes
        btnReporte.setOnClickListener {
            startActivity(Intent(this, ReporteActivity::class.java))
        }

        // Abrir actividad de Configuración
        btnConfiguracion.setOnClickListener {
            startActivity(Intent(this, ConfiguracionActivity::class.java))
        }

        // Cerrar sesión
        btnCerrarSesion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}

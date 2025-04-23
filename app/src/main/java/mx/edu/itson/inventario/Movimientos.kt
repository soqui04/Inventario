package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MovimientosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movimientos)

        val etArticulo = findViewById<EditText>(R.id.etArticulo)
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val etFecha = findViewById<EditText>(R.id.etFecha)
        val etMotivo = findViewById<EditText>(R.id.etMotivo)
        val rgTipoMovimiento = findViewById<RadioGroup>(R.id.rgTipoMovimiento)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrarMovimiento)

        btnRegistrar.setOnClickListener {
            val articulo = etArticulo.text.toString()
            val cantidad = etCantidad.text.toString()
            val fecha = etFecha.text.toString()
            val motivo = etMotivo.text.toString()
            val tipo = when (rgTipoMovimiento.checkedRadioButtonId) {
                R.id.rbEntrada -> "Entrada"
                R.id.rbSalida -> "Salida"
                else -> ""
            }

            if (articulo.isBlank() || cantidad.isBlank() || fecha.isBlank() || tipo.isBlank()) {
                Toast.makeText(this, "Completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                // Simular guardado
                val mensaje = "$tipo registrada: $cantidad de '$articulo' el $fecha"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}

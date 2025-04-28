package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EmpleadosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados)

        val btnAgregarUsuario = findViewById<Button>(R.id.btnAgregarUsuario)

        btnAgregarUsuario.setOnClickListener {
            startActivity(Intent(this, AgregarUsuarioActivity::class.java))
        }
    }
}

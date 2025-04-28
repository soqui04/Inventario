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

<<<<<<< HEAD
=======
        // Al hacer click, abre el formulario para agregar un empleado
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        btnAgregarUsuario.setOnClickListener {
            startActivity(Intent(this, AgregarUsuarioActivity::class.java))
        }
    }
}

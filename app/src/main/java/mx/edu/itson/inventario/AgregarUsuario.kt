package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class AgregarUsuarioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etTelefono: EditText
    private lateinit var btnGuardarUsuario: Button

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_usuario)

        db = FirebaseFirestore.getInstance()

        etNombre = findViewById(R.id.etNombre)
        etCorreo = findViewById(R.id.etCorreo)
        etTelefono = findViewById(R.id.etTelefono)
        btnGuardarUsuario = findViewById(R.id.btnGuardarUsuario)

        btnGuardarUsuario.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()

            if (nombre.isNotEmpty() && correo.isNotEmpty() && telefono.isNotEmpty()) {
                guardarUsuarioEnFirestore(nombre, correo, telefono)
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun guardarUsuarioEnFirestore(nombre: String, correo: String, telefono: String) {
        val usuario = hashMapOf(
            "nombre" to nombre,
            "correo" to correo,
            "telefono" to telefono
        )

        db.collection("empleados")
            .add(usuario)
            .addOnSuccessListener {
                Toast.makeText(this, "Empleado agregado exitosamente", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al agregar empleado: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}

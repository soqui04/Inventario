package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import com.google.firebase.firestore.FirebaseFirestore
=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

class AgregarUsuarioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etTelefono: EditText
    private lateinit var btnGuardarUsuario: Button

<<<<<<< HEAD
    private lateinit var db: FirebaseFirestore

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_usuario)

<<<<<<< HEAD
        db = FirebaseFirestore.getInstance()

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        etNombre = findViewById(R.id.etNombre)
        etCorreo = findViewById(R.id.etCorreo)
        etTelefono = findViewById(R.id.etTelefono)
        btnGuardarUsuario = findViewById(R.id.btnGuardarUsuario)

        btnGuardarUsuario.setOnClickListener {
<<<<<<< HEAD
            val nombre = etNombre.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()

            if (nombre.isNotEmpty() && correo.isNotEmpty() && telefono.isNotEmpty()) {
                guardarUsuarioEnFirestore(nombre, correo, telefono)
=======
            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()
            val telefono = etTelefono.text.toString()

            if (nombre.isNotEmpty() && correo.isNotEmpty() && telefono.isNotEmpty()) {
                Toast.makeText(this, "Usuario agregado", Toast.LENGTH_SHORT).show()
                finish()
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
<<<<<<< HEAD

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
=======
}
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

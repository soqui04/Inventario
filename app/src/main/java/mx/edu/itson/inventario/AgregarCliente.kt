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

class AgregarClienteActivity : AppCompatActivity() {

    private lateinit var etNombreCliente: EditText
    private lateinit var etDireccion: EditText
    private lateinit var etTelefonoCliente: EditText
    private lateinit var btnGuardarCliente: Button

<<<<<<< HEAD
    private lateinit var db: FirebaseFirestore

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

<<<<<<< HEAD
        db = FirebaseFirestore.getInstance()

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        etNombreCliente = findViewById(R.id.etNombreCliente)
        etDireccion = findViewById(R.id.etDireccion)
        etTelefonoCliente = findViewById(R.id.etTelefonoCliente)
        btnGuardarCliente = findViewById(R.id.btnGuardarCliente)

        btnGuardarCliente.setOnClickListener {
<<<<<<< HEAD
            val nombre = etNombreCliente.text.toString().trim()
            val direccion = etDireccion.text.toString().trim()
            val telefono = etTelefonoCliente.text.toString().trim()

            if (nombre.isNotEmpty() && direccion.isNotEmpty() && telefono.isNotEmpty()) {
                guardarClienteEnFirestore(nombre, direccion, telefono)
=======
            val nombre = etNombreCliente.text.toString()
            val direccion = etDireccion.text.toString()
            val telefono = etTelefonoCliente.text.toString()

            if (nombre.isNotEmpty() && direccion.isNotEmpty() && telefono.isNotEmpty()) {
                Toast.makeText(this, "Cliente agregado", Toast.LENGTH_SHORT).show()
                finish()
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
<<<<<<< HEAD

    private fun guardarClienteEnFirestore(nombre: String, direccion: String, telefono: String) {
        val cliente = hashMapOf(
            "nombre" to nombre,
            "direccion" to direccion,
            "telefono" to telefono
        )

        db.collection("clientes")
            .add(cliente)
            .addOnSuccessListener {
                Toast.makeText(this, "Cliente agregado exitosamente", Toast.LENGTH_SHORT).show()
                finish() // Cierra esta pantalla
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al agregar cliente: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}
=======
}
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

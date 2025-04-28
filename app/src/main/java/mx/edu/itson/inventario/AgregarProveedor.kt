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

class AgregarProveedorActivity : AppCompatActivity() {

    private lateinit var etNombreProveedor: EditText
    private lateinit var etEmpresa: EditText
    private lateinit var etTelefonoProveedor: EditText
    private lateinit var btnGuardarProveedor: Button

<<<<<<< HEAD
    private lateinit var db: FirebaseFirestore

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_proveedor)

<<<<<<< HEAD
        db = FirebaseFirestore.getInstance()

=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        etNombreProveedor = findViewById(R.id.etNombreProveedor)
        etEmpresa = findViewById(R.id.etEmpresa)
        etTelefonoProveedor = findViewById(R.id.etTelefonoProveedor)
        btnGuardarProveedor = findViewById(R.id.btnGuardarProveedor)

        btnGuardarProveedor.setOnClickListener {
<<<<<<< HEAD
            val nombre = etNombreProveedor.text.toString().trim()
            val empresa = etEmpresa.text.toString().trim()
            val telefono = etTelefonoProveedor.text.toString().trim()

            if (nombre.isNotEmpty() && empresa.isNotEmpty() && telefono.isNotEmpty()) {
                guardarProveedorEnFirestore(nombre, empresa, telefono)
=======
            val nombre = etNombreProveedor.text.toString()
            val empresa = etEmpresa.text.toString()
            val telefono = etTelefonoProveedor.text.toString()

            if (nombre.isNotEmpty() && empresa.isNotEmpty() && telefono.isNotEmpty()) {
                Toast.makeText(this, "Proveedor agregado", Toast.LENGTH_SHORT).show()
                finish()
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
<<<<<<< HEAD

    private fun guardarProveedorEnFirestore(nombre: String, empresa: String, telefono: String) {
        val proveedor = hashMapOf(
            "nombre" to nombre,
            "empresa" to empresa,
            "telefono" to telefono
        )

        db.collection("proveedores")
            .add(proveedor)
            .addOnSuccessListener {
                Toast.makeText(this, "Proveedor agregado exitosamente", Toast.LENGTH_SHORT).show()
                finish() // Cerrar pantalla
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al agregar proveedor: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}
=======
}
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

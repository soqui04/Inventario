package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class AgregarProveedorActivity : AppCompatActivity() {

    private lateinit var etNombreProveedor: EditText
    private lateinit var etEmpresa: EditText
    private lateinit var etTelefonoProveedor: EditText
    private lateinit var btnGuardarProveedor: Button

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_proveedor)

        db = FirebaseFirestore.getInstance()

        etNombreProveedor = findViewById(R.id.etNombreProveedor)
        etEmpresa = findViewById(R.id.etEmpresa)
        etTelefonoProveedor = findViewById(R.id.etTelefonoProveedor)
        btnGuardarProveedor = findViewById(R.id.btnGuardarProveedor)

        btnGuardarProveedor.setOnClickListener {
            val nombre = etNombreProveedor.text.toString().trim()
            val empresa = etEmpresa.text.toString().trim()
            val telefono = etTelefonoProveedor.text.toString().trim()

            if (nombre.isNotEmpty() && empresa.isNotEmpty() && telefono.isNotEmpty()) {
                guardarProveedorEnFirestore(nombre, empresa, telefono)
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

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

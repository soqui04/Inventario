package mx.edu.itson.inventario

<<<<<<< HEAD

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.util.Log
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore






class ConfiguracionActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
=======
<<<<<<< HEAD
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ConfiguracionActivity : AppCompatActivity() {

=======
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class ConfiguracionActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val etConfirmar = findViewById<EditText>(R.id.etConfirmar)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarCambios)

<<<<<<< HEAD

        val sharedPreferences = getSharedPreferences("mi_app", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("user_id", null)

=======
<<<<<<< HEAD
=======
        val sharedPreferences = getSharedPreferences("mi_app", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("user_id", null)

>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()
            val contrasena = etContrasena.text.toString()
            val confirmar = etConfirmar.text.toString()

            if (nombre.isBlank() || correo.isBlank() || contrasena.isBlank() || confirmar.isBlank()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (contrasena != confirmar) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
<<<<<<< HEAD
            }  else if (userId != null) {
=======
<<<<<<< HEAD
            } else {
                Toast.makeText(this, "Cambios guardados (simulado)", Toast.LENGTH_SHORT).show()
                finish()
=======
            } else if (userId != null) {
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

                db.collection("users")
                    .document(userId)
                    .update(
                        mapOf(
                            "nombre" to nombre,
                            "correo" to correo,
                            "contrasena" to contrasena
                        )
                    )
                    .addOnSuccessListener {
                        Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error al actualizar datos", Toast.LENGTH_SHORT).show()
                        Log.e("Firestore", "Error al actualizar usuario", e)
                    }
            } else {
                Toast.makeText(this, "Error: usuario no encontrado", Toast.LENGTH_SHORT).show()
<<<<<<< HEAD
=======
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            }
        }
    }
}

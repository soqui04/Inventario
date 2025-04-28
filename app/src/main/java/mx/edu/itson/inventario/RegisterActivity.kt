package mx.edu.itson.inventario

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.firestore

class RegisterActivity : AppCompatActivity() {

    private val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        FirebaseApp.initializeApp(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvGoToLogin = findViewById<TextView>(R.id.tvGoToLogin)

        btnRegister.setOnClickListener {
            val nombre = etNombre.text.toString()
            val email = etEmail.text.toString()
            val pass = etPassword.text.toString()
            val confirm = etConfirmPassword.text.toString()

            if (nombre.isBlank() || email.isBlank() || pass.isBlank() || confirm.isBlank()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (pass != confirm) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {
                val db = Firebase.firestore

                val user = hashMapOf(
                    "nombre" to nombre,
                    "correo" to email,
                    "contrasena" to pass
                )

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show()
                        Log.e("Firestore", "Error al registrar usuario", e)
                    }
            }
        }

        tvGoToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun registrarUsuarioEnFirestore(nombre: String, email: String, password: String) {
        val db = Firebase.firestore

        val usuario = hashMapOf(
            "nombre" to nombre,
            "correo" to email,
            "contrasena" to password
        )

        db.collection("users")
            .add(usuario)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Usuario registrado con ID: ${documentReference.id}")
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Log.e(TAG, "Error al registrar usuario", e)
                Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
            }
    }
}

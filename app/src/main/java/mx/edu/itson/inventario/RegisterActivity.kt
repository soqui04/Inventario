package mx.edu.itson.inventario

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
=======
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
>>>>>>> 264c246 (database first changes)

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

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
<<<<<<< HEAD
                // Aquí se registraría el usuario (simulado por ahora)
                Toast.makeText(this, "Registro exitoso (simulado)", Toast.LENGTH_SHORT).show()
=======
                val db = Firebase.firestore

                val user = hashMapOf(
                    "nombre" to nombre,
                    "correo" to email,
                    "contrasena" to pass
                )

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }

                // FALTA VALIDAR PASSWORD SEGURA DE 8 CARACTERES, VALIDAR CORREO QUE TENGA @ALGO.COM Y YA

                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
>>>>>>> 264c246 (database first changes)
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        tvGoToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}

package mx.edu.itson.inventario

<<<<<<< HEAD
=======
<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
<<<<<<< HEAD
=======
>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegisterLink = findViewById<TextView>(R.id.tvRegisterLink)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
<<<<<<< HEAD
                verificarUsuario(email, password) { usuarioExiste ->
                    if (usuarioExiste) {
                        Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Inicio de sesión incorrecto, revisa los datos", Toast.LENGTH_SHORT).show()
                    }
                }
=======
<<<<<<< HEAD
                // Aquí en el futuro iría la verificación con BD
                Toast.makeText(this, "Inicio de sesión exitoso (simulado)", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
=======

                verificarUsuario(email, password) { usuarioExiste ->
                    if (usuarioExiste) {
                        Toast.makeText(this, "Inicio de sesión exitoso ", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {

                        Toast.makeText(this, "Inicio de sesión incorrecto, revisa los datos", Toast.LENGTH_SHORT).show()
                    }
                }



>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            }
        }

        tvRegisterLink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
<<<<<<< HEAD

    private fun verificarUsuario(correo: String, contrasena: String, onResult: (Boolean) -> Unit) {
=======
<<<<<<< HEAD
=======

    fun verificarUsuario(correo: String, contrasena: String, onResult: (Boolean) -> Unit){
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
        val db = FirebaseFirestore.getInstance()

        db.collection("users")
            .whereEqualTo("correo", correo)
            .whereEqualTo("contrasena", contrasena)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val userDocument = documents.documents[0]
                    val userId = userDocument.id

<<<<<<< HEAD
=======

>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
                    val sharedPreferences = getSharedPreferences("mi_app", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putString("user_id", userId).apply()

                    onResult(true)
                } else {
                    onResult(false)
                }
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore", "Error al verificar usuario: ", exception)
                onResult(false)
            }
    }
<<<<<<< HEAD
}
=======
>>>>>>> 264c246 (database first changes)
}
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

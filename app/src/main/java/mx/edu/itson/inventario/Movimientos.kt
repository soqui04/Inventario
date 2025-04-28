package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import com.google.firebase.firestore.FirebaseFirestore





class MovimientosActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

=======
<<<<<<< HEAD

class MovimientosActivity : AppCompatActivity() {

=======
import com.google.firebase.firestore.FirebaseFirestore

class MovimientosActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

>>>>>>> 264c246 (database first changes)
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movimientos)

        val etArticulo = findViewById<EditText>(R.id.etArticulo)
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val etFecha = findViewById<EditText>(R.id.etFecha)
        val etMotivo = findViewById<EditText>(R.id.etMotivo)
        val rgTipoMovimiento = findViewById<RadioGroup>(R.id.rgTipoMovimiento)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrarMovimiento)

        btnRegistrar.setOnClickListener {
<<<<<<< HEAD
=======
<<<<<<< HEAD
            val articulo = etArticulo.text.toString()
            val cantidad = etCantidad.text.toString()
            val fecha = etFecha.text.toString()
            val motivo = etMotivo.text.toString()
            val tipo = when (rgTipoMovimiento.checkedRadioButtonId) {
                R.id.rbEntrada -> "Entrada"
                R.id.rbSalida -> "Salida"
                else -> ""
            }

            if (articulo.isBlank() || cantidad.isBlank() || fecha.isBlank() || tipo.isBlank()) {
                Toast.makeText(this, "Completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                // Simular guardado
                val mensaje = "$tipo registrada: $cantidad de '$articulo' el $fecha"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
                finish()
=======
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            val articuloNombre = etArticulo.text.toString()
            val cantidadTexto = etCantidad.text.toString()
            val fecha = etFecha.text.toString()
            val motivo = etMotivo.text.toString()
            val tipo = when (rgTipoMovimiento.checkedRadioButtonId) {
                R.id.rbEntrada -> "entrada"
                R.id.rbSalida -> "salida"
                else -> ""
            }

            if (articuloNombre.isBlank() || cantidadTexto.isBlank() || fecha.isBlank() || tipo.isBlank()) {
<<<<<<< HEAD
                Toast.makeText(this, "Completa todos los campos obligatorios", Toast.LENGTH_SHORT)
                    .show()
=======
                Toast.makeText(this, "Completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
            } else {
                val cantidadMovimiento = cantidadTexto.toInt()

                db.collection("articulo")
                    .whereEqualTo("nombre", articuloNombre)
                    .get()
                    .addOnSuccessListener { documentos ->
                        if (!documentos.isEmpty) {
                            val articuloDoc = documentos.documents[0]
                            val articuloId = articuloDoc.id
                            val cantidadActual = articuloDoc.getLong("cantidad")?.toInt() ?: 0

                            var nuevaCantidad = cantidadActual

                            if (tipo == "entrada") {
                                nuevaCantidad += cantidadMovimiento
                            } else if (tipo == "salida") {
                                if (cantidadActual >= cantidadMovimiento) {
                                    nuevaCantidad -= cantidadMovimiento
                                } else {
<<<<<<< HEAD
                                    Toast.makeText(
                                        this,
                                        "No hay suficiente stock para esta salida",
                                        Toast.LENGTH_SHORT
                                    ).show()
=======
                                    Toast.makeText(this, "No hay suficiente stock para esta salida", Toast.LENGTH_SHORT).show()
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
                                    return@addOnSuccessListener
                                }
                            }

                            db.collection("articulo")
                                .document(articuloId)
                                .update("cantidad", nuevaCantidad)
                                .addOnSuccessListener {
<<<<<<< HEAD
                                    // Registrar el movimiento
=======

>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
                                    val movimiento = hashMapOf(
                                        "articulo" to articuloNombre,
                                        "cantidad" to cantidadMovimiento,
                                        "fecha" to fecha,
                                        "motivo" to motivo,
                                        "tipo" to tipo
                                    )

                                    db.collection("movimientos")
                                        .add(movimiento)
                                        .addOnSuccessListener {
<<<<<<< HEAD
                                            Toast.makeText(
                                                this,
                                                "Movimiento registrado correctamente",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                            finish()
                                        }
                                        .addOnFailureListener { e ->
                                            Toast.makeText(
                                                this,
                                                "Error al registrar movimiento",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(
                                        this,
                                        "Error al actualizar el stock",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                        } else {
                            Toast.makeText(this, "Artículo no encontrado", Toast.LENGTH_SHORT)
                                .show()
=======
                                            Toast.makeText(this, "Movimiento registrado correctamente", Toast.LENGTH_SHORT).show()
                                            finish()
                                        }
                                        .addOnFailureListener { e ->
                                            Toast.makeText(this, "Error al registrar movimiento", Toast.LENGTH_SHORT).show()
                                        }
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(this, "Error al actualizar el stock", Toast.LENGTH_SHORT).show()
                                }
                        } else {
                            Toast.makeText(this, "Artículo no encontrado", Toast.LENGTH_SHORT).show()
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61
                        }
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error buscando artículo", Toast.LENGTH_SHORT).show()
                    }
<<<<<<< HEAD
            }
        }
    }

}

=======
>>>>>>> 264c246 (database first changes)
            }
        }
    }
}
>>>>>>> 6e0f556c0c294ea83e05ce9627209d0dc6225c61

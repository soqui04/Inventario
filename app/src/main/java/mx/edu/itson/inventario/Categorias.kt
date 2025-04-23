package mx.edu.itson.inventario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class CategoriasActivity : AppCompatActivity() {

    private lateinit var listaCategorias: ListView
    private lateinit var btnAgregarCategoria: Button
    private val categorias = mutableListOf("Ropa - Azul", "Electrónica - Verde", "Papelería - Amarillo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        listaCategorias = findViewById(R.id.listaCategorias)
        btnAgregarCategoria = findViewById(R.id.btnAgregarCategoria)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, categorias)
        listaCategorias.adapter = adaptador

        btnAgregarCategoria.setOnClickListener {
            val input = EditText(this)
            input.hint = "Ej. Juguetes - Rojo"

            AlertDialog.Builder(this)
                .setTitle("Nueva categoría")
                .setView(input)
                .setPositiveButton("Agregar") { _, _ ->
                    val texto = input.text.toString()
                    if (texto.isNotBlank()) {
                        categorias.add(texto)
                        adaptador.notifyDataSetChanged()
                        Toast.makeText(this, "Categoría agregada", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "No se agregó ninguna categoría", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        listaCategorias.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Categoría: ${categorias[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}

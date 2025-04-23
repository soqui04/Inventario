package mx.edu.itson.inventario

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class ReporteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte)

        val barChart = findViewById<BarChart>(R.id.barChart)

        // Datos simulados
        val categorias = listOf("Ropa", "Electrónica", "Papelería", "Juguetes")
        val cantidades = listOf(40f, 25f, 10f, 30f)

        val entries = ArrayList<BarEntry>()
        for (i in cantidades.indices) {
            entries.add(BarEntry(i.toFloat(), cantidades[i]))
        }

        val dataSet = BarDataSet(entries, "Artículos por Categoría")
        dataSet.colors = listOf(
            Color.parseColor("#64B5F6"),
            Color.parseColor("#81C784"),
            Color.parseColor("#FFD54F"),
            Color.parseColor("#E57373")
        )

        val barData = BarData(dataSet)
        barChart.data = barData

        // Configurar eje X con nombres
        val xAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(categorias)
        xAxis.granularity = 1f
        xAxis.setDrawGridLines(false)
        xAxis.labelRotationAngle = -45f
        xAxis.position = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM

        // Configurar eje Y
        barChart.axisLeft.axisMinimum = 0f
        barChart.axisRight.isEnabled = false

        // Quitar descripción por defecto
        val description = Description()
        description.text = ""
        barChart.description = description

        barChart.animateY(1000)
        barChart.invalidate()
    }
}

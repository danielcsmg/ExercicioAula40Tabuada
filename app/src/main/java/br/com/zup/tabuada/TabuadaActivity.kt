package br.com.zup.tabuada

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.tabuada.databinding.ActivityTabuadaBinding

class TabuadaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityTabuadaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val numero = intent.getStringExtra("numero") ?:"O"
        val buttonRefazer = binding.btnRefazerCalculo

        mostrarTabuada(binding.tvCalcZero, R.string.resultado, "0", numero, calcularTabuada(numero.toInt(), 0))
        mostrarTabuada(binding.tvCalcUm, R.string.resultado, "1", numero, calcularTabuada(numero.toInt(), 1))
        mostrarTabuada(binding.tvCalcDois, R.string.resultado, "2", numero, calcularTabuada(numero.toInt(), 2))
        mostrarTabuada(binding.tvCalcTres, R.string.resultado, "3", numero, calcularTabuada(numero.toInt(), 3))
        mostrarTabuada(binding.tvCalcQuatro, R.string.resultado, "4", numero, calcularTabuada(numero.toInt(), 4))
        mostrarTabuada(binding.tvCalcCinco, R.string.resultado, "5", numero, calcularTabuada(numero.toInt(), 5))
        mostrarTabuada(binding.tvCalcSeis, R.string.resultado, "6", numero, calcularTabuada(numero.toInt(), 6))
        mostrarTabuada(binding.tvCalcSete, R.string.resultado, "7", numero, calcularTabuada(numero.toInt(), 7))
        mostrarTabuada(binding.tvCalcOito, R.string.resultado, "8", numero, calcularTabuada(numero.toInt(), 8))
        mostrarTabuada(binding.tvCalcNove, R.string.resultado, "9", numero, calcularTabuada(numero.toInt(), 9))
        mostrarTabuada(binding.tvCalcDez, R.string.resultado, "10", numero, calcularTabuada(numero.toInt(), 10))

        buttonRefazer.setOnClickListener {
            refazerCalculo()
        }
    }

    fun calcularTabuada(multiplicando: Int, multiplicador: Int): String {
        return (multiplicando * multiplicador).toString()
    }

    fun mostrarTabuada(textView: TextView, textoResultado: Int, multiplicador: String, multiplicando: String, resultado: String){
        textView.text = getString(textoResultado, multiplicador, multiplicando, resultado)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun refazerCalculo(){
        onBackPressed()
    }
}
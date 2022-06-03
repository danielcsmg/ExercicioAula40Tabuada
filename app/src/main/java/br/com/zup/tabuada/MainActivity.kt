package br.com.zup.tabuada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import br.com.zup.tabuada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var numeroDigitado: String
        val buttonCalcular = binding.btnCalcular

        buttonCalcular.setOnClickListener {
            numeroDigitado = binding.etNumeroDigitado.text.toString()
            if(verificarEntrada(numeroDigitado, binding.etNumeroDigitado)) {
                val intent = Intent(this, TabuadaActivity::class.java).apply {
                    putExtra("numero", numeroDigitado)
                }
                startActivity(intent)
                limparDados(binding)
            }
        }
    }

    fun verificarEntrada(num: String, editText: EditText): Boolean{
        if (num.isBlank()){
            editText.error = getString(R.string.msg_erro)
        }
        return num.isNotBlank()
    }

    fun limparDados(binding: ActivityMainBinding){
        binding.etNumeroDigitado.text.clear()
    }
}
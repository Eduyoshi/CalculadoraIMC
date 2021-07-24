package com.projetos.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var listaResultado: MutableList<Resultado>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }


    private fun setListeners(){
        heightEDT?.doAfterTextChanged { text ->
            //Toast.makeText(this,text.toString(), Toast.LENGTH_SHORT).show()
        }
        weightEDT?.doOnTextChanged{text, _, _, _ ->
        //titleTXT?.text = text
        }
        calcBT?.setOnClickListener {
            calcularIMC(weightEDT.text.toString(), heightEDT.text.toString())
        }
    }

    private fun calcularIMC(peso:String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso != null && altura != null){
            val imc = peso/(altura*altura)
            titleTXT.text = "Seu IMC é \n $imc"
            salvaResultado(peso,altura,imc)
        }

    }

    private fun salvaResultado(peso: Float, altura: Float, imc: Float) {
        var resultado = Resultado(peso, altura, imc)
        listaResultado.add(resultado)
    }

}
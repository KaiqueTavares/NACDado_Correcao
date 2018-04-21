package br.com.kaiquetavares.nacdado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    var vitorias = 0
    var derrotas = 0
    var empates = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btPlay.setOnClickListener{
            jogar()
        }
    }

    fun jogar (){
        val gerador = Random()
        val numeroPlayer = gerador.nextInt(6)+1
        val numeroPC = gerador.nextInt(6)+1

        configuraJogada(numeroPlayer,ivPlayer)
        configuraJogada(numeroPC,ivPC)

        //Se meu INT do player for menor que meu Int do PC ele perdeu
        if (numeroPlayer < numeroPC){
            //Então subo minhas derrotas
            derrotas++
            //E seto o text com minha variavel.
            tvDerrotas.text = derrotas.toString()
        }else if (numeroPlayer > numeroPC){
            vitorias++
            tvVitorias.text = vitorias.toString()
        }else {
            empates++
            tvEmpates.text = empates.toString()
        }
    }

    //Crio uma função para configurar minha jogada que recebe um numero gerado no Fun Jogar()
    //e recebe um imageView (PARA SABER AONDE ELE VAI COLOCAR ESTA IMAGEM)
    fun configuraJogada (numero: Int, imageView: ImageView){
        //Quando ele receber o numero ele verificar o que
        when(numero){
            1 -> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice_1))
            2 -> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice_2))
            3 -> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice_3))
            4 -> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice_4))
            5 -> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice_5))
            6 -> imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice_6))
        }
    }
}

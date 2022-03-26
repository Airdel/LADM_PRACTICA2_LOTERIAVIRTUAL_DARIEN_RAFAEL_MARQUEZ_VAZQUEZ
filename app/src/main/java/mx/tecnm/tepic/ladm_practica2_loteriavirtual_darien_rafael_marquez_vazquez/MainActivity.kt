package mx.tecnm.tepic.ladm_practica2_loteriavirtual_darien_rafael_marquez_vazquez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import mx.tecnm.tepic.ladm_practica2_loteriavirtual_darien_rafael_marquez_vazquez.databinding.ActivityMainBinding

var cartas1 = mutableListOf(R.drawable.carta1,R.drawable.carta2,R.drawable.carta3,R.drawable.carta4,
                            R.drawable.carta5,R.drawable.carta6,R.drawable.carta7,R.drawable.carta8,
                        R.drawable.carta9,R.drawable.carta10,R.drawable.carta11,R.drawable.carta12,
                        R.drawable.carta13,R.drawable.carta14,R.drawable.carta15,R.drawable.carta16,
                        R.drawable.carta17,R.drawable.carta18,R.drawable.carta19,R.drawable.carta20,
                        R.drawable.carta21,R.drawable.carta22,R.drawable.carta23,R.drawable.carta24,
                        R.drawable.carta25,R.drawable.carta26,R.drawable.carta27,R.drawable.carta28,
                        R.drawable.carta29,R.drawable.carta30,R.drawable.carta31,R.drawable.carta32,
                        R.drawable.carta33,R.drawable.carta34,R.drawable.carta35,R.drawable.carta36,
                        R.drawable.carta37,R.drawable.carta38,R.drawable.carta39,R.drawable.carta40,
                        R.drawable.carta41,R.drawable.carta42,R.drawable.carta43,R.drawable.carta44,
                        R.drawable.carta45,R.drawable.carta46,R.drawable.carta47,R.drawable.carta48,
                        R.drawable.carta49,R.drawable.carta50,R.drawable.carta51,R.drawable.carta52,
                        R.drawable.carta53,R.drawable.carta54)
var cartas2 = cartas1

var cartaSonido1 = mutableListOf(R.raw.a1,R.raw.a2,R.raw.a3,R.raw.a4,R.raw.a5,R.raw.a6,R.raw.a7,R.raw.a8,
                        R.raw.a9,R.raw.a10,R.raw.a11,R.raw.a12,R.raw.a13,R.raw.a14,R.raw.a15,R.raw.a16,
                        R.raw.a17,R.raw.a18,R.raw.a19,R.raw.a20,R.raw.a21,R.raw.a22,R.raw.a23,R.raw.a24,
                        R.raw.a25,R.raw.a26,R.raw.a27,R.raw.a28,R.raw.a29,R.raw.a30,R.raw.a31,R.raw.a32,
                        R.raw.a33,R.raw.a34,R.raw.a35,R.raw.a36,R.raw.a37,R.raw.a38,R.raw.a39,R.raw.a40,
                        R.raw.a41,R.raw.a42,R.raw.a43,R.raw.a44,R.raw.a45,R.raw.a46,R.raw.a47,R.raw.a48,
                        R.raw.a49,R.raw.a50,R.raw.a51,R.raw.a52,R.raw.a53,R.raw.a54)
var cartaSonido2 = cartaSonido1

lateinit var imageCarta : ImageView

lateinit var txtTitulo : TextView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var partida : Hilos
    lateinit var revision : Carta_Corrutina
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageCarta = binding.imageCarta

        txtTitulo = binding.txtTitulo
        var txtTitulo = binding.txtTitulo
        var btnIniciar = binding.btnIniciar
        var btnLoteria = binding.btnLoteria
        var btnVerificar = binding.btnVerificar
        var btnReiniciar = binding.btnReiniciar
        var hilochecker = false
        btnIniciar.setOnClickListener {
            if(!hilochecker) {
                try {
                    btnIniciar.visibility = View.GONE
                    btnLoteria.visibility = View.VISIBLE
                    partida = Hilos(imageCarta, txtTitulo, this)
                    partida.start()
                    hilochecker = true
                    return@setOnClickListener

                } catch (Exception: Exception) {

                }
            }
        }//fin de btnIniciar.setOnClickListener
        btnLoteria.setOnClickListener {
            try{
                btnVerificar.visibility = View.VISIBLE
                btnReiniciar.visibility = View.VISIBLE
                btnLoteria.visibility = View.GONE
                txtTitulo.text = "¡Lotería!"
                partida.loteria()
            }catch (e : Exception){
                txtTitulo.text = "${e.message}"
            }
        }

        btnVerificar.setOnClickListener {
            try {
                btnVerificar.visibility = View.GONE
                txtTitulo.text = "Revisión de cartas, Cartas faltantes:"
                revision = Carta_Corrutina(imageCarta, txtTitulo, this)
                revision.revisarCartas()
            }catch (e:Exception){
                txtTitulo.text = "${e.message}"
            }
        }
    }//fin de Oncreate
}//fin de clase


package mx.tecnm.tepic.ladm_practica2_loteriavirtual_darien_rafael_marquez_vazquez

import android.media.MediaPlayer
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class Carta_Corrutina(imagenEnviada : ImageView, etiquetaEnviada : TextView, este:MainActivity) {
    val este = este
    val imagenEnviadaGlobal = imagenEnviada
    val etiquetaEnviadaGlobal = etiquetaEnviada
    lateinit var scope: CoroutineScope
    lateinit var corrutina : CoroutineContext
    lateinit var revision : CoroutineContext

    init {
        scope = CoroutineScope(Job() + Dispatchers.Main)
    }
    fun revisarCartas(){
        revision=scope.launch(EmptyCoroutineContext,CoroutineStart.LAZY){
            delay(2000)
            try {
                while(cartas2.size !=0) {
                    if (cartas2.size != 0) {
                        este.runOnUiThread {
                            var n = Random.nextInt(0, cartas2.size)
                            imagenEnviadaGlobal.setImageResource(cartas2[n])
                            var mp = MediaPlayer.create(este, cartaSonido2[n])
                            mp.start()
                            cartas2.removeAt(n)
                            cartaSonido2.removeAt(n)


                        }
                    }
                }
                    if (cartas2.size == 0) {
                        imagenEnviadaGlobal.setImageResource(R.drawable.carta1)
                        etiquetaEnviadaGlobal.text = "Juego finalizado"
                        cartas2 = cartas1
                    }


                Thread.sleep(2000)
            }catch (Exceptionnnnnn : Exception){
                etiquetaEnviadaGlobal.text = "${Exceptionnnnnn.message}"
            }
        }
        (revision as Job).start()
    }

    fun cancelarRevision(){
        revision.cancel()
    }
}
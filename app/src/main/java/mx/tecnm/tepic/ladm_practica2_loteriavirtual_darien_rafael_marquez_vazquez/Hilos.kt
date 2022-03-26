package mx.tecnm.tepic.ladm_practica2_loteriavirtual_darien_rafael_marquez_vazquez

import android.media.MediaPlayer
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class Hilos(imagenEnviada : ImageView, etiquetaEnviada : TextView, este:MainActivity) : Thread(){

        private var pausar = false
        private var ejecutar = true
        val este = este
        val imagenEnviadaGlobal = imagenEnviada
        val etiquetaEnviadaGlobal = etiquetaEnviada
        override fun run() {
            super.run()
            while (ejecutar){
                if(!pausar){
                    try {
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
                        if (cartas2.size == 0) {
                            imagenEnviadaGlobal.setImageResource(R.drawable.carta1)
                            etiquetaEnviadaGlobal.text = "Juego finalizado"
                            cartas2 = cartas1
                        }


                        sleep(2000)
                    }catch (Exceptionnnnnn : Exception){
                        etiquetaEnviadaGlobal.text = "${Exceptionnnnnn.message}"
                    }
                }
            }
        }
    fun loteria(){
        ejecutar = false
    }
}
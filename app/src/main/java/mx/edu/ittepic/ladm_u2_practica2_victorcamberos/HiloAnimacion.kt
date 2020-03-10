package mx.edu.ittepic.ladm_u2_practica2_victorcamberos

class HiloAnimacion (p:MainActivity):Thread(){
    var puntero = p
    override fun run() {
        super.run()

        while(true){
            puntero.runOnUiThread {
                puntero.lienzo!!.animarCirculo()
            }
            sleep(50)
        }
    }
}
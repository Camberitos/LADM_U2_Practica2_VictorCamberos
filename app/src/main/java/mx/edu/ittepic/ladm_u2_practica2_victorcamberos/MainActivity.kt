package mx.edu.ittepic.ladm_u2_practica2_victorcamberos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var lienzo  : Lienzo ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)

        HiloAnimacion(this).start()
    }
}

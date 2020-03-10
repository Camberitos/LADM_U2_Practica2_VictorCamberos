package mx.edu.ittepic.ladm_u2_practica2_victorcamberos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    // se requiere p para que view sepa cual activity va a trabajar
    var puntero = p
    /*var cx = 150f
    var cy = 150f
    var tx = 733f
    var ty = 818f*/
    var circulo = FiguraGeometrica(200, 1000, 30)
    var circulo2 = FiguraGeometrica(100, 2000, 60)
    var circulo3 = FiguraGeometrica(750, 1800, 90)
    var circulo4 = FiguraGeometrica(150, 150, 120)
    var circulo5 = FiguraGeometrica(50, 1500, 150)
    var circulo6 = FiguraGeometrica(500, 1100, 180)
    var punteroFiguraGeometrica: FiguraGeometrica? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

        canvas.drawColor(Color.WHITE)

        /*//Dibujando un cuadrado VERDE Contorno AZUL
        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        cuadrado.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLUE
        cuadrado.pintar(canvas, paint)

        //Dibujando el rectangulo
        paint.style = Paint.Style.FILL
        paint.color = Color.YELLOW
        rectangulo.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.GRAY
        rectangulo.pintar(canvas, paint)
        */

        //Dibujando circulo
        paint.color = Color.WHITE
        circulo.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.RED
        paint.strokeWidth = 10f
        circulo.pintar(canvas, paint)

        //Dibujando circulo2
        paint.color = Color.WHITE
        circulo2.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.GREEN
        paint.strokeWidth = 10f
        circulo2.pintar(canvas, paint)

        //Dibujando circulo3
        paint.color = Color.WHITE
        circulo3.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.GRAY
        paint.strokeWidth = 10f
        circulo3.pintar(canvas, paint)

        //Dibujando circulo4
        paint.color = Color.WHITE
        circulo4.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLUE
        paint.strokeWidth = 10f
        circulo4.pintar(canvas, paint)

        //Dibujando circulo5
        paint.color = Color.WHITE
        circulo5.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.YELLOW
        paint.strokeWidth = 10f
        circulo5.pintar(canvas, paint)

        //Dibujando circulo6
        paint.color = Color.WHITE
        circulo6.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = 10f
        circulo6.pintar(canvas, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //REVISAMOS QUIEN ESTA EN AREA
                if (circulo.estaEnArea(event)) {
                    punteroFiguraGeometrica = circulo
                    puntero.setTitle("TOCASTE CIRCULO")
                }
                /*if (cuadrado.estaEnArea(event)) {
                    punteroFiguraGeometrica = cuadrado
                    puntero.setTitle("TOCASTE CUADRADO")
                }
                if (rectangulo.estaEnArea(event)) {
                    punteroFiguraGeometrica = rectangulo
                    puntero.setTitle("TOCASTE RECTANGULO")
                }
              */if (circulo2.estaEnArea(event)) {
                    punteroFiguraGeometrica = circulo2
                    puntero.setTitle("TOCASTE CIRCULO2")
                }
                if (circulo3.estaEnArea(event)) {
                    punteroFiguraGeometrica = circulo3
                    puntero.setTitle("TOCASTE CIRCULO3")
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (punteroFiguraGeometrica != null) {
                    punteroFiguraGeometrica!!.arrastrar(event)
                }

            }
            MotionEvent.ACTION_UP -> {
                punteroFiguraGeometrica = null
            }
        }
        invalidate()
        return true
    }

    fun animarCirculo() {
        circulo.rebote(width,height,30)
        circulo2.rebote(width, height,60)
        circulo3.rebote(width, height,90)
        circulo4.rebote(width,height,120)
        circulo5.rebote(width, height,150)
        circulo6.rebote(width, height,180)
        invalidate()
    }
}
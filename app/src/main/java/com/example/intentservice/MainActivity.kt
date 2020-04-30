package com.example.intentservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        var salidaStatic : TextView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        salidaStatic = salida
        val filtro = IntentFilter(ReceptorOperacion().ACTION_RESP)
        filtro.addCategory(Intent.CATEGORY_DEFAULT)
        registerReceiver(ReceptorOperacion(),filtro)
    }

    fun calcularOperacion(view: View) {
        view.isEnabled = false
        val n = entrada.text.toString().toDoubleOrNull()
        salida.append("$n ^2 = ")
//        val i = Intent(this,ServicioOperacion::class.java)
        val i = Intent(this,IntentServiceOperacion::class.java)
        i.putExtra("numero",n)
        startService(i)
    }

    inner class ReceptorOperacion : BroadcastReceiver(){
        val ACTION_RESP = "com.example.intentservice.intent.action.RESPUESTA_OPERACION"
        override fun onReceive(context: Context?, intent: Intent?) {
            val res = intent?.getDoubleExtra("resultado",0.0)
            salida.append(" ${res} \n")
            btnCalcular.isEnabled = true
        }

    }
}

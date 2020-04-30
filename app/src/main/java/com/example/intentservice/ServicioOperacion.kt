package com.example.intentservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock

class ServicioOperacion : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val n = intent?.extras?.getDouble("numero")
        SystemClock.sleep(25000)
        MainActivity.salidaStatic?.append("${if(n!=null)n*n else 0} \n")
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}

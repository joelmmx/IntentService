package com.example.intentservice

import android.annotation.SuppressLint
import android.app.IntentService
import android.content.Intent
import android.os.SystemClock

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions and extra parameters.
 */
class IntentServiceOperacion : IntentService("IntentServiceOperacion") {

//    @SuppressLint("WrongThread")
    override fun onHandleIntent(intent: Intent?) {
        val n = intent?.extras?.getDouble("numero")
        SystemClock.sleep(25000)
//        MainActivity.salidaStatic?.append("${if(n!=null)n*n else 0} \n")
        val i = Intent()
        i.setAction(MainActivity().ReceptorOperacion().ACTION_RESP)
        i.addCategory(Intent.CATEGORY_DEFAULT)
        i.putExtra("resultado",(if(n!=null) n*n else 0) as Double)
        sendBroadcast(i)
    }
}

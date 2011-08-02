/*Copyright [2010-2011] [David Van de Ven]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.wahtod.wififixer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BootService extends Service {
    private Context ctxt;
    private Service bootservice;
    /*
     * Runnable for boot service start
     */
    private class tStartService implements Runnable {
	@Override
	public void run() {
	    try {
		Thread.sleep(ServiceAlarm.STARTDELAY);
	    } catch (InterruptedException e) {
		Log.i("BroadCastHandler", "Startup Thread Interrupted");
	    }

	    /**
	     * Start Service
	     */
	    ctxt.startService(new Intent(ctxt, WifiFixerService.class));
	    bootservice.stopSelf();
	}
    };

    @Override
    public void onCreate() {
	ctxt=this.getApplicationContext();
	bootservice = this;
	Thread serviceStart = new Thread(new tStartService());
	   serviceStart.start();
	super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
	/*
	 * Mandatory override
	 */
	return null;
    }

   
}
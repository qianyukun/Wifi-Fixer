/*Copyright [2010-2012] [David Van de Ven]

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
package org.wahtod.wififixer.utility;

public class StopWatch {
	/*
	 * Provides timing services
	 */
	private long start;
	private long stop;
	private boolean running;
	
	public StopWatch() {
		start = 0;
		stop = 0;
	}

	public void start() {
		this.start = System.currentTimeMillis();
		this.running = true;
	}

	public void stop() {
		this.stop = System.currentTimeMillis();
		this.running = false;
	}

	public long getElapsed() {
		long elapsed;
		if (running) {
			elapsed = (System.currentTimeMillis() - start);
		} else {
			elapsed = (stop - start);
		}
		return elapsed;
	}
}

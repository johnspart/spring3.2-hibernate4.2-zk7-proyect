/**
 * 
 */
package co.edu.utils.threads;

import services.ServiceManager;

/**
 * @author 696768
 * 
 */
public class Hilos implements Runnable {

	private ServiceManager serviceManager;

	public Hilos(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++)
				serviceManager.getAllPersonas();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

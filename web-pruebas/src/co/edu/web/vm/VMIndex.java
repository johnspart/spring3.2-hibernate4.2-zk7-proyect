/**
 * 
 */
package co.edu.web.vm;

import java.util.List;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;

import services.ServiceManager;
import co.edu.awaa.maping.anotations.Personas;
import co.edu.utils.ServiceLocator;

/**
 * @author 696768
 * 
 */
public class VMIndex {
	private List<Personas> personas;

	@Init
	public void init() {
		try {
			/*
			 * Executor executor = Executors.newCachedThreadPool();
			 * 
			 * for (int i = 0; i < 100; i++) { executor.execute(new
			 * Hilos(ServiceLocator.getInstance()
			 * .getServicio(ServiceManager.class.getSimpleName(),
			 * ServiceManager.class))); }
			 */
			this.personas = ServiceLocator
					.getInstance()
					.getServicio(ServiceManager.class.getSimpleName(),
							ServiceManager.class).getAllPersonas();

		} catch (Exception e) {
			Messagebox.show(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @return the personas
	 */
	public List<Personas> getPersonas() {
		return personas;
	}

	/**
	 * @param personas
	 *            the personas to set
	 */
	public void setPersonas(List<Personas> personas) {
		this.personas = personas;
	}
}

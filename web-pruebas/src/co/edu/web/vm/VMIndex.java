/**
 * 
 */
package co.edu.web.vm;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.theme.Themes;

import services.ServiceManager;
import co.edu.awaa.maping.anotations.Personas;
import co.edu.utils.ServiceLocator;
import co.edu.web.vm.utils.BuilderZK;

/**
 * @author 696768
 * 
 */
public class VMIndex extends BuilderZK {
	private final String rutaNuevaPersonaWin = "/zul/maestros/personas/nuevaPersona.zul";
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
			showErrorMessage(e);
			e.printStackTrace();
		}
	}

	@Command
	public void nuevaPersonaWin(@BindingParam("win") Component win) {
		Component component = Executions.createComponents(rutaNuevaPersonaWin,
				win, null);
		if (component instanceof org.zkoss.zul.Window) {
			((Window) component).doModal();
		}
	}

	@Command("guardarPersona")
	public void guardarPersona(@BindingParam("numD") String numD,
			@BindingParam("tipoD") String tipoD,
			@BindingParam("nombre") String nombre,
			@BindingParam("apell") String apellido1) {
		Personas personas = new Personas();
		personas.setNroDocumento(numD);
		personas.setTipoDocumento(tipoD);
		personas.setNombre(nombre);
		personas.setApellido1(apellido1);

		try {
			ServiceLocator
					.getInstance()
					.getServicio(ServiceManager.class.getSimpleName(),
							ServiceManager.class)
					.guardarOActualizarPersona(personas);
		} catch (Exception e) {
			showErrorMessage(e);
			e.printStackTrace();
		}

	}

	@Command
	@NotifyChange("*")
	public void eliminarPersonas() {
		try {
			for (Personas persona : this.personas) {
				if ("Web".equals(persona.getNombre())) {
					ServiceLocator
							.getInstance()
							.getServicio(ServiceManager.class.getSimpleName(),
									ServiceManager.class)
							.eliminarPersonas(persona);
				}
			}
		} catch (Exception e) {
			showErrorMessage(e);
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

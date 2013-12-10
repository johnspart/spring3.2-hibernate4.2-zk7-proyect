/**
 * 
 */
package co.edu.web.vm;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import services.ServiceManager;
import co.edu.awaa.maping.anotations.Personas;
import co.edu.generic.dao.impl.PagingResult;
import co.edu.utils.ServiceLocator;
import co.edu.web.utils.PagingCacheVO;
import co.edu.web.vm.utils.BuilderZK;

/**
 * @author 696768
 * 
 */
public class VMIndex extends BuilderZK {
	private final String rutaNuevaPersonaWin = "/zul/maestros/personas/nuevaPersona.zul";
	/*
	 * private List<String> paginasRecorridas; private ListModelList<Personas>
	 * personas; private ListModelList<Personas> personasMdl; private int
	 * activePage = 0; private int totalSize = 0; private int pageSize = 5;
	 */

	private PagingCacheVO<Personas> pgcPersonas;

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
			/*
			 * Se asigna el tamaño de la lista con slo datos en la pagina actual
			 * this.personas = new ListModelList<Personas>(ServiceLocator
			 * .getInstance() .getServicio(ServiceManager.class.getSimpleName(),
			 * ServiceManager.class) .getAllPersonasPaging(10, 1, null));
			 * this.paginasRecorridas = new ArrayList<String>();
			 * this.paginasRecorridas.add(1 + "");
			 */

			this.pgcPersonas = new PagingCacheVO<>(
					new ListModelList<Personas>(), 0, 6, 0);

			PagingResult<Personas> pagingResult = ServiceLocator
					.getInstance()
					.getServicio(ServiceManager.class.getSimpleName(),
							ServiceManager.class)
					.getPersonasPagingWithSize(this.pgcPersonas.getPageSize(),
							1, null);

			this.pgcPersonas.addPagingResult(pagingResult, 1);

		} catch (Exception e) {
			showErrorMessage(e);
			e.printStackTrace();
		}
	}

	@NotifyChange("*")
	@Override
	public void afterCompose(Component view) {
		super.afterCompose(view);
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
			addMessage("Implementar");
			showMessage(Messagebox.EXCLAMATION, null);
		} catch (Exception e) {
			showErrorMessage(e);
			e.printStackTrace();
		}
	}

	@Command("cambiodepagina")
	@NotifyChange("*")
	public void cambiodepagina(@BindingParam("page") int page) {
		try {
			page++;

			this.pgcPersonas.getListMdl().clear();

			if (this.pgcPersonas.containsPage(page)) {
				this.pgcPersonas.getListMdl().addAll(
						this.pgcPersonas.getPageList(page));
			} else {

				this.pgcPersonas.addPagingResult(
						ServiceLocator
								.getInstance()
								.getServicio(
										ServiceManager.class.getSimpleName(),
										ServiceManager.class)
								.getPersonasPagingWithSize(
										this.pgcPersonas.getPageSize(), page,
										null), page);
			}
		} catch (Exception e) {
			super.showErrorMessage(e);
			e.printStackTrace();
		}
	}

	/**
	 * @return the pgcPersonas
	 */
	public PagingCacheVO<Personas> getPgcPersonas() {
		return pgcPersonas;
	}

	/**
	 * @param pgcPersonas
	 *            the pgcPersonas to set
	 */
	public void setPgcPersonas(PagingCacheVO<Personas> pgcPersonas) {
		this.pgcPersonas = pgcPersonas;
	}

}

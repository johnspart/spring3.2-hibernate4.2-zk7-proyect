/**
 * 
 */
package co.edu.web.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zul.ListModelList;

import co.edu.generic.dao.impl.PagingResult;

/**
 * Clase que permite el manejo de paginación y cache para las paginas ya
 * visitadas para reducir las llamadas a la base de datos
 * 
 * Se implementan "org.zkoss.zul.ListModelList" para otros sistemas sin zk se
 * pueden implementar clases que heredan de "java.util.List"
 * 
 * V=1.0.0
 * 
 * @author johnspart
 * 
 */
public class PagingCacheVO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1625158885680095789L;

	private ListModelList<T> listMdl;
	private Map<String, List<T>> listFull;
	private int activePage = 0;
	private int totalSize = 0;
	private int pageSize = 10;

	/**
	 * para crear la lista inicial
	 * 
	 * @param listFull
	 * @param activePage
	 * @param pageSize
	 */
	public PagingCacheVO(List<T> listFull, int activePage, int pageSize,
			int totalSize) {
		super();
		this.listFull = new HashMap<String, List<T>>();

		this.listFull.put(
				new StringBuilder().append(activePage + 1).toString(),
				new ListModelList<T>(listFull));

		this.listMdl = new ListModelList<T>(
				this.listFull.get(new StringBuilder().append(activePage + 1)
						.toString()));

		this.activePage = activePage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}

	/**
	 * 
	 * @param listMdl
	 * @param listFull
	 * @param activePage
	 * @param totalSize
	 * @param pageSize
	 */
	public PagingCacheVO(ListModelList<T> listMdl, List<T> listFull,
			int activePage, int totalSize, int pageSize) {
		super();
		this.listFull = new HashMap<String, List<T>>();

		this.listFull.put(
				new StringBuilder().append(activePage + 1).toString(),
				new ListModelList<T>(listFull));

		this.listMdl = new ListModelList<T>(
				this.listFull.get(new StringBuilder().append(activePage + 1)
						.toString()));

		this.activePage = activePage;
		this.totalSize = totalSize;
		this.pageSize = pageSize;
	}

	/**
	 * Se crea un nuevo objeto que parte desde la pagina 1
	 * 
	 * @param pagingResult
	 */
	public PagingCacheVO(PagingResult<T> pagingResult, int page) {
		super();
		this.listFull = new HashMap<String, List<T>>();

		this.listFull.put(
				new StringBuilder().append(activePage + 1).toString(),
				new ListModelList<T>(pagingResult.getList()));

		this.listMdl = new ListModelList<T>(
				this.listFull.get(new StringBuilder().append(page).toString()));

		this.totalSize = pagingResult.getRowsCount();
	}

	/**
	 * Se le asigna al objeto los valores del paging result
	 * 
	 * @param pagingResult
	 * @param page
	 */
	public void addPagingResult(PagingResult<T> pagingResult, int page) {
		if (listFull == null)
			this.listFull = new HashMap<String, List<T>>();
		this.listFull.put(new StringBuilder().append(page).toString(),
				pagingResult.getList());
		this.listMdl = new ListModelList<T>(listFull.get(new StringBuilder()
				.append(page).toString()));
		this.totalSize = pagingResult.getRowsCount();
	}

	/**
	 * Retorna una lista de elementos de la pagina solicitada
	 * 
	 * @param page
	 * @return lista de elementos
	 */
	public List<T> getPageList(int page) {
		return this.listFull.get(new StringBuilder().append(page).toString());
	}

	/**
	 * Agrega una pagina a la lista para aclarar que esta ya esta cargada
	 * 
	 * @param pageNumber
	 */
	public void addPage(int pageNumber, List<T> elemnts) {
		this.listFull.put(new StringBuilder().append(pageNumber).toString(),
				elemnts);
	}

	public void setMdlAndAddFull(List<T> elements, int page) {
		this.listFull.put(new StringBuilder().append(page).toString(),
				new ListModelList<T>(elements));
		this.listMdl.clear();
		this.listMdl.addAll(elements);
	}

	/**
	 * Retorna falso o verdadero si la pagina existe
	 * 
	 * @param pageNumber
	 * @return true o false
	 */
	public boolean containsPage(int pageNumber) {
		return this.listFull.containsKey(new StringBuilder().append(pageNumber)
				.toString());
	}

	/**
	 * Inicio de GET's y SET's
	 */
	/**
	 * @return the listMdl
	 */
	public ListModelList<T> getListMdl() {
		return listMdl;
	}

	/**
	 * @param listMdl
	 *            the listMdl to set
	 */
	public void setListMdl(ListModelList<T> listMdl) {
		this.listMdl = listMdl;
	}

	/**
	 * @return the activePage
	 */
	public int getActivePage() {
		return activePage;
	}

	/**
	 * @param activePage
	 *            the activePage to set
	 */
	public void setActivePage(int activePage) {
		this.activePage = activePage;
	}

	/**
	 * @return the totalSize
	 */
	public int getTotalSize() {
		return totalSize;
	}

	/**
	 * @param totalSize
	 *            the totalSize to set
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the listFull
	 */
	public Map<String, List<T>> getListFull() {
		return listFull;
	}

	/**
	 * @param listFull
	 *            the listFull to set
	 */
	public void setListFull(Map<String, List<T>> listFull) {
		this.listFull = listFull;
	}
}

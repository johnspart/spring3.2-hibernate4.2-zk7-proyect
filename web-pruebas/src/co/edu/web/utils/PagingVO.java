/**
 * 
 */
package co.edu.web.utils;

import java.io.Serializable;
import java.util.List;

import org.zkoss.zul.ListModelList;

import co.edu.generic.dao.impl.PagingResult;

/**
 * Clase que permite el manejo de paginación
 * 
 * Se implementan "org.zkoss.zul.ListModelList" para otros sistemas sin zk se
 * pueden implementar clases que heredan de "java.util.List"
 * 
 * V=0.9.0
 * 
 * @author johnspart
 * 
 */
public class PagingVO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5173697199009561541L;

	private ListModelList<T> listMdl;
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
	public PagingVO(List<T> listMdl, int activePage, int pageSize, int totalSize) {
		super();
		this.listMdl = new ListModelList<T>(listMdl);

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
	public PagingVO(ListModelList<T> listMdl, int activePage, int totalSize,
			int pageSize) {
		super();

		this.listMdl = new ListModelList<T>(listMdl);

		this.activePage = activePage;
		this.totalSize = totalSize;
		this.pageSize = pageSize;
	}

	/**
	 * Se crea un nuevo objeto que parte dede la pagina 1
	 * 
	 * @param pagingResult
	 */
	public PagingVO(PagingResult<T> pagingResult, int page) {
		super();
		this.listMdl = new ListModelList<T>(pagingResult.getList());
		this.totalSize = pagingResult.getRowsCount();
	}

	/**
	 * Se le asigna al objeto los valores del paging result se merma en uno el
	 * valor de page, para asignarle el valor a "this.activePage"
	 * 
	 * @param pagingResult
	 * @param page
	 */
	public void setLstMdl(PagingResult<T> pagingResult, int page) {
		this.listMdl = new ListModelList<T>(pagingResult.getList());
		this.activePage = page--;
		this.totalSize = pagingResult.getRowsCount();
	}

	/**
	 * Se le asigna al objeto los valores del "elements" se merma en uno el
	 * valor de page, para asignarle el valor a "this.activePage"
	 * 
	 * @param elements
	 * @param page
	 */
	public void setLstMdl(List<T> elements, int page) {
		this.listMdl = new ListModelList<T>(elements);
		this.activePage = page--;
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

}

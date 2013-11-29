/**
 * 
 */
package co.edu.generic.dao.impl;

import java.util.List;

/**
 * @author 696768
 * 
 */
public class PagingResult<T> {
	/**
	 * varibel que que posee el numero total de filas
	 */
	private int rowsCount;
	/**
	 * posee los registros devueltos en la consulta
	 */
	private List<T> list;

	/**
	 * 
	 */
	public PagingResult() {
		super();
	}

	/**
	 * @param rowsCount
	 * @param list
	 */
	public PagingResult(int rowsCount, List<T> list) {
		super();
		this.rowsCount = rowsCount;
		this.list = list;
	}

	/**
	 * @return the rowsCount
	 */
	public int getRowsCount() {
		return rowsCount;
	}

	/**
	 * @param rowsCount
	 *            the rowsCount to set
	 */
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public void setRowsCount(Long rowsCount) {
		this.rowsCount = rowsCount.intValue();
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
}

/**
 * 
 */
package co.edu.generic.dao;

/**
 * @author john
 *
 */

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import co.edu.generic.dao.impl.PagingResult;

public interface GenericDAO<T, Key extends Serializable> {

	/**
	 * Elimina un elemento
	 * 
	 * @param elemento
	 * @throws Exception
	 */
	void delete(T obj) throws Exception;

	/**
	 * Busca un elemento por su identificador (clave primaria)
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param id
	 * @return elemento T
	 * @throws Exception
	 */
	T find(Class<T> clazz, Key id) throws Exception;

	public Integer editHQL(Class<T> clazz, final String hql,
			Map<String, Object> params) throws Exception;

	List<T> findCriteriaDinamico(DetachedCriteria detachedCriteria)
			throws Exception;

	/**
	 * Busca todos los elementos.
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> findAll(Class<T> clazz) throws Exception;

	/**
	 * Busca todos los elementos, aplicando la condición especificada en la
	 * variable <code>filter</code>
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param filter
	 *            condici�n a aplicar a la búsqueda
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> findAll(Class<T> clazz, String filter) throws Exception;

	/**
	 * Busca elementos deacuerdo al sql recibido
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param sql
	 *            condici�n a aplicar a la búsqueda
	 * @return lista de elementos
	 * @throws Exception
	 */
	public List<T> findAllSql(Class<T> clazz, final String sql)
			throws Exception;

	/**
	 * Busca elementos deacuerdo al hql recibido
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param hql
	 *            condici�n a aplicar a la búsqueda
	 * @return lista de elementos
	 * @throws Exception
	 */
	public List<T> findHql(Class<T> clazz, String hql) throws Exception;

	/**
	 * Actualiza elementos deacuerdo al sql recibido
	 * 
	 * @param clazz
	 *            representa la clase del elemento a actualizar
	 * @param sql
	 *            condición a aplicar a la actualización
	 * @return valor del cambio
	 * @throws Exception
	 */
	public Integer saveOrUpdateSql(Class<T> clazz, final String sql)
			throws Exception;

	/**
	 * Busca todos los elementos, aplicando la condición especificada en la
	 * variable <code>filter</code> en el order especificado <code>order</code>
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param filter
	 *            condición a aplicar a la búsqueda
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> findAll(Class<T> clazz, String filter, String order)
			throws Exception;

	/**
	 * Busca todos los elementos que cumplan con las condiciones indicadas en el
	 * atributo <code>params</code>
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param params
	 *            mapa de <nombre parámetro, valor> los cuales se aplican a la
	 *            búsqueda
	 * @return lista de elementos mapa de <nombre parámetro, valor> los cuales
	 *         se aplican a la búsqueda
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> findAll(Class<T> clazz, Map<String, Object> params)
			throws Exception;

	/**
	 * Busca todos los elementos que cumplan con las condiciones indicadas en el
	 * atributo <code>params</code>
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param params
	 *            mapa de <nombre parámetro, valor> los cuales se aplican a la
	 *            b�squeda
	 * @param orderProperty
	 *            nombre del o los atributo por el cual se debe ordenar el
	 *            resultado. El orden es ascendente
	 * @return lista de elementos
	 * 
	 * @throws Exception
	 */
	List<T> findAll(Class<T> clazz, Map<String, Object> params,
			String orderProperty) throws Exception;

	/**
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param params
	 *            mapa de <nombre parametro, valor> los cuales se aplican a la
	 *            busqueda
	 * @param orderProperty
	 *            nombre del o los atributo por el cual se debe ordenar el
	 *            resultado.
	 * @param desc
	 *            si es true el orden es descendente en caso de que el parametro
	 *            orderProperty no sea vacío. Si es false el orden es
	 *            ascendente
	 * @return lista de elementos
	 * 
	 * @throws Exception
	 */
	List<T> findAll(Class<T> clazz, Map<String, Object> params,
			String orderProperty, boolean desc) throws Exception;

	/**
	 * Busca todos los elementos que cumplan con las condiciones indicadas en el
	 * atributo <code>params</code>
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param hql
	 *            estructura hql de la busqueda
	 * @param params
	 *            mapa de <nombre parametro, valor> los cuales se aplican a la
	 *            búsqueda
	 * @return lista de elementos
	 * @throws Exception
	 */
	public List<T> findHql(Class<T> clazz, String hql,
			Map<String, Object> params) throws Exception;

	/**
	 * Busca los elementos aplicando el ejemplo recibido
	 * 
	 * @param ejemplo
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> findAllByExample(T ejemplo) throws Exception;

	/**
	 * Busca el elemento que cumpla las condiciones del ejemplo (sea igual)
	 * 
	 * @param ejemplo
	 * @return el elemento
	 * @throws Exception
	 */
	T findByExample(T ejemplo) throws Exception;

	/**
	 * Guarda el elemento.
	 * 
	 * @param obj
	 * @return T
	 * @throws Exception
	 */
	T save(T obj) throws Exception;

	/**
	 * Realiza la actualización del elemento
	 * 
	 * @param obj
	 * @throws Exception
	 */
	void update(T obj) throws Exception;

	/**
	 * Guarda o actualiza el elemento, según aplique.
	 * 
	 * @param obj
	 * @throws Exception
	 */
	void saveOrUpdate(T obj) throws Exception;

	/**
	 * Almacena o actualiza todos los elementos de la colección.
	 * 
	 * @param listaElementos
	 * @throws Exception
	 */
	void saveOrUpdateAll(List<T> listaElementos) throws Exception;

	/**
	 * Realiza la ejecuci�n de la NamedQuery especificada con el
	 * <code>queryName</code>
	 * 
	 * @param queryName
	 *            nombre de la consulta a ejecutar
	 * @param nombreParametros
	 * @param valoresParametros
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> executeNameQuery(String queryName, String[] nombreParametros,
			Object[] valoresParametros) throws Exception;

	/**
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	T merge(T obj) throws Exception;

	/**
	 * Busca todos los elementos que cumplan con las condiciones indicadas en el
	 * atributo <code>params</code>
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param sql
	 *            estructura sql de la busqueda
	 * @param params
	 *            mapa de <nombre parámetro, valor> los cuales se aplican a la
	 *            búsqueda
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> findSql(Class<T> clazz, String sql, Map<String, Object> params)
			throws Exception;

	/**
	 * Busca todos los elementos que cumplan con las condiciones indicadas en el
	 * atributo <code>params</code> y transforma la salida a una clase que no es
	 * de tipo entidad
	 * 
	 * @param clazz
	 *            representa la clase del elemento a buscar
	 * @param sql
	 *            estructura sql de la busqueda
	 * @param params
	 *            mapa de <nombre parámetro, valor> los cuales se aplican a la
	 *            b�squeda
	 * @return lista de elementos
	 * @throws Exception
	 */
	List<T> findSqlBean(Class<T> clazz, String sql, Map<String, Object> params)
			throws Exception;

	/**
	 * Realiza consulta limitada por los parametros recibidos
	 * 
	 * @param detachedCriteria
	 *            manejador de la consulta
	 * @param pageSize
	 *            tama�o de la lista a devolver y a buscar
	 * @param page
	 *            pagina actual
	 * @return Bean que contiene el numero de elemenstos totales y la lista de
	 *         elementos devueltos en la consulta
	 * @throws Exception
	 */
	PagingResult<T> findCriteriaDinamicoPageResult(
			DetachedCriteria detachedCriteria, int pageSize, int page)
			throws Exception;

	/**
	 * Realiza consulta limitada por los parametros recibidos
	 * 
	 * @param detachedCriteria
	 *            manejador de la consulta
	 * @param limit
	 *            tama�o de la lista a devolver y a buscar
	 * @return Lista de elementos devueltos en la consulta
	 * @throws Exception
	 */
	List<T> findCriteriaDinamico(DetachedCriteria detachedCriteria, int limit)
			throws Exception;

	/**
	 * Realiza consulta limitada por los parametros recibidos
	 * 
	 * @param detachedCriteria
	 *            manejador de la consulta
	 * @param pageSize
	 *            tama�o de la lista a devolver y a buscar
	 * @param page
	 *            pagina actual
	 * @return Lista de elementos devueltos en la consulta
	 * @throws Exception
	 */
	List<T> findCriteriaDinamico(DetachedCriteria detachedCriteria,
			int pageSize, int page) throws Exception;

	/**
	 * 
	 * Realiza consulta limitada por los parametros recibidos y devuelve
	 * lacantidad de filas encontrada pero solo contienen valores la pagina
	 * solicitada, los valores extra se devuelven nulos "No se recomienda el uso
	 * para acceder a datos muy grandes para la clase GenericDAOImpl"
	 * 
	 * @param detachedCriteria
	 * @param pageSize
	 * @param page
	 * @return lista de elementos
	 * @throws Exception
	 */
	@Deprecated
	List<T> findDetachedCriteriaFirst(DetachedCriteria detachedCriteria,
			int pageSize, int page) throws Exception;

}

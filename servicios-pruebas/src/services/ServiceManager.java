/**
 * 
 */
package services;

import java.util.List;

import co.edu.awaa.maping.anotations.Personas;
import co.edu.generic.dao.impl.PagingResult;

/**
 * @author 696768
 * 
 */
public interface ServiceManager {
	public List<Personas> getAllPersonas() throws Exception;

	void guardarOActualizarPersona(Personas personas) throws Exception;

	void eliminarPersonas(Personas personas) throws Exception;

	List<Personas> getAllPersonasPaging(int pageSize, int page)
			throws Exception;

	PagingResult<Personas> getPersonasPagingWithSize(int pageSize, int page,
			Integer listSize) throws Exception;

}

package services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import services.ServiceManager;
import co.edu.awaa.maping.anotations.Personas;
import co.edu.generic.dao.GenericDAO;
import co.edu.generic.dao.impl.PagingResult;

/**
 * 
 */

/**
 * @author 696768
 * 
 */
public class ServiceManagerImpl implements ServiceManager {
	GenericDAO<Personas, String> personasDAO;

	@Override
	public List<Personas> getAllPersonas() throws Exception {
		return personasDAO.findAll(Personas.class);
	}

	@Override
	public List<Personas> getAllPersonasPaging(int pageSize, int page)
			throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(
				Personas.class, "Per");

		return personasDAO.findCriteriaDinamico(detachedCriteria, pageSize,
				page);

	}

	@Override
	public PagingResult<Personas> getPersonasPagingWithSize(int pageSize, int page,
			Integer listSize) throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(
				Personas.class, "Per");
		if (listSize == null) {
			return personasDAO.findCriteriaDinamicoPageResult(detachedCriteria,
					pageSize, page);
		} else {
			return new PagingResult<Personas>(listSize,
					this.personasDAO.findCriteriaDinamico(detachedCriteria,
							pageSize));
		}
	}

	@Override
	public void guardarOActualizarPersona(Personas personas) throws Exception {
		this.personasDAO.saveOrUpdate(personas);
	}

	@Override
	public void eliminarPersonas(Personas personas) throws Exception {
		this.personasDAO.delete(personas);
	}

	/**
	 * @param personasDAO
	 *            the personasDAO to set
	 */
	public void setPersonasDAO(GenericDAO<Personas, String> personasDAO) {
		this.personasDAO = personasDAO;
	}
}

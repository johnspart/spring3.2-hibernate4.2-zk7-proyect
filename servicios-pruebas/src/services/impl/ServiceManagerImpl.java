package services.impl;

import java.util.List;

import services.ServiceManager;
import co.edu.awaa.maping.anotations.Personas;
import co.edu.generic.dao.GenericDAO;

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

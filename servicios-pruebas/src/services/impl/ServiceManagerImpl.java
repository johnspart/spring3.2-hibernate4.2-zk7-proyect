package services.impl;

import java.util.List;

import co.edu.awaa.maping.anotations.Personas;
import co.edu.generic.dao.GenericDAO;
import services.ServiceManager;

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

	/**
	 * @param personasDAO
	 *            the personasDAO to set
	 */
	public void setPersonasDAO(GenericDAO<Personas, String> personasDAO) {
		this.personasDAO = personasDAO;
	}

}

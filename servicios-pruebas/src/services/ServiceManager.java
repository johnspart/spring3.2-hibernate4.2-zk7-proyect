/**
 * 
 */
package services;

import java.util.List;

import co.edu.awaa.maping.anotations.Personas;

/**
 * @author 696768
 * 
 */
public interface ServiceManager {
	public List<Personas> getAllPersonas() throws Exception;

	void guardarOActualizarPersona(Personas personas) throws Exception;

	void eliminarPersonas(Personas personas) throws Exception;
}

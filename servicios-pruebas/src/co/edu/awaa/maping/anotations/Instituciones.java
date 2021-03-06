package co.edu.awaa.maping.anotations;

// Generated Nov 29, 2013 10:36:17 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Instituciones generated by hbm2java
 */
@Entity
@Table(name = "instituciones", schema = "maestros")
public class Instituciones implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3757360164257469808L;
	private String nitInstitucion;
	private String nombreInstitucion;
	private String observaciones;
	private Set<SedesInstitucion> sedesInstitucions = new HashSet<SedesInstitucion>(
			0);
	private Set<AsignacionEventos> asignacionEventoses = new HashSet<AsignacionEventos>(
			0);

	public Instituciones() {
	}

	public Instituciones(String nitInstitucion, String nombreInstitucion) {
		this.nitInstitucion = nitInstitucion;
		this.nombreInstitucion = nombreInstitucion;
	}

	public Instituciones(String nitInstitucion, String nombreInstitucion,
			String observaciones, Set<SedesInstitucion> sedesInstitucions,
			Set<AsignacionEventos> asignacionEventoses) {
		this.nitInstitucion = nitInstitucion;
		this.nombreInstitucion = nombreInstitucion;
		this.observaciones = observaciones;
		this.sedesInstitucions = sedesInstitucions;
		this.asignacionEventoses = asignacionEventoses;
	}

	@Id
	@Column(name = "nit_institucion", unique = true, nullable = false)
	public String getNitInstitucion() {
		return this.nitInstitucion;
	}

	public void setNitInstitucion(String nitInstitucion) {
		this.nitInstitucion = nitInstitucion;
	}

	@Column(name = "nombre_institucion", nullable = false)
	public String getNombreInstitucion() {
		return this.nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituciones")
	public Set<SedesInstitucion> getSedesInstitucions() {
		return this.sedesInstitucions;
	}

	public void setSedesInstitucions(Set<SedesInstitucion> sedesInstitucions) {
		this.sedesInstitucions = sedesInstitucions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituciones")
	public Set<AsignacionEventos> getAsignacionEventoses() {
		return this.asignacionEventoses;
	}

	public void setAsignacionEventoses(
			Set<AsignacionEventos> asignacionEventoses) {
		this.asignacionEventoses = asignacionEventoses;
	}

}

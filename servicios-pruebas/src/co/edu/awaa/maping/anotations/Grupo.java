package co.edu.awaa.maping.anotations;

// Generated Nov 29, 2013 10:36:17 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Grupo generated by hbm2java
 */
@Entity
@Table(name = "grupo", schema = "maestros")
public class Grupo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5890375210193153695L;
	private long idGrupo;
	private SedesInstitucion sedesInstitucion;
	private String dsGrupo;
	private Date fechaInicio;
	private Date fechaFinal;
	private String claveRegistro;
	private Set<PaginasContenido> paginasContenidos = new HashSet<PaginasContenido>(
			0);
	private Set<AsignaturasPorGrupos> asignaturasPorGruposes = new HashSet<AsignaturasPorGrupos>(
			0);
	private Set<AsignacionEventos> asignacionEventoses = new HashSet<AsignacionEventos>(
			0);
	private Set<PropietarioGrupo> propietarioGrupos = new HashSet<PropietarioGrupo>(
			0);
	private Set<PersonasGrupos> personasGruposes = new HashSet<PersonasGrupos>(
			0);

	public Grupo() {
	}

	public Grupo(long idGrupo, SedesInstitucion sedesInstitucion, String dsGrupo) {
		this.idGrupo = idGrupo;
		this.sedesInstitucion = sedesInstitucion;
		this.dsGrupo = dsGrupo;
	}

	public Grupo(long idGrupo, SedesInstitucion sedesInstitucion,
			String dsGrupo, Date fechaInicio, Date fechaFinal,
			String claveRegistro, Set<PaginasContenido> paginasContenidos,
			Set<AsignaturasPorGrupos> asignaturasPorGruposes,
			Set<AsignacionEventos> asignacionEventoses,
			Set<PropietarioGrupo> propietarioGrupos,
			Set<PersonasGrupos> personasGruposes) {
		this.idGrupo = idGrupo;
		this.sedesInstitucion = sedesInstitucion;
		this.dsGrupo = dsGrupo;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.claveRegistro = claveRegistro;
		this.paginasContenidos = paginasContenidos;
		this.asignaturasPorGruposes = asignaturasPorGruposes;
		this.asignacionEventoses = asignacionEventoses;
		this.propietarioGrupos = propietarioGrupos;
		this.personasGruposes = personasGruposes;
	}

	@Id
	@Column(name = "id_grupo", unique = true, nullable = false)
	public long getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sedes_ins", nullable = false)
	public SedesInstitucion getSedesInstitucion() {
		return this.sedesInstitucion;
	}

	public void setSedesInstitucion(SedesInstitucion sedesInstitucion) {
		this.sedesInstitucion = sedesInstitucion;
	}

	@Column(name = "ds_grupo", nullable = false)
	public String getDsGrupo() {
		return this.dsGrupo;
	}

	public void setDsGrupo(String dsGrupo) {
		this.dsGrupo = dsGrupo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", length = 13)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_final", length = 13)
	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Column(name = "clave_registro")
	public String getClaveRegistro() {
		return this.claveRegistro;
	}

	public void setClaveRegistro(String claveRegistro) {
		this.claveRegistro = claveRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<PaginasContenido> getPaginasContenidos() {
		return this.paginasContenidos;
	}

	public void setPaginasContenidos(Set<PaginasContenido> paginasContenidos) {
		this.paginasContenidos = paginasContenidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<AsignaturasPorGrupos> getAsignaturasPorGruposes() {
		return this.asignaturasPorGruposes;
	}

	public void setAsignaturasPorGruposes(
			Set<AsignaturasPorGrupos> asignaturasPorGruposes) {
		this.asignaturasPorGruposes = asignaturasPorGruposes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<AsignacionEventos> getAsignacionEventoses() {
		return this.asignacionEventoses;
	}

	public void setAsignacionEventoses(
			Set<AsignacionEventos> asignacionEventoses) {
		this.asignacionEventoses = asignacionEventoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<PropietarioGrupo> getPropietarioGrupos() {
		return this.propietarioGrupos;
	}

	public void setPropietarioGrupos(Set<PropietarioGrupo> propietarioGrupos) {
		this.propietarioGrupos = propietarioGrupos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<PersonasGrupos> getPersonasGruposes() {
		return this.personasGruposes;
	}

	public void setPersonasGruposes(Set<PersonasGrupos> personasGruposes) {
		this.personasGruposes = personasGruposes;
	}

}

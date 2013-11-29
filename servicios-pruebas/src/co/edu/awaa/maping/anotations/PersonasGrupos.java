package co.edu.awaa.maping.anotations;

// Generated Nov 29, 2013 10:36:17 AM by Hibernate Tools 4.0.0

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
import javax.persistence.UniqueConstraint;

/**
 * PersonasGrupos generated by hbm2java
 */
@Entity
@Table(name = "personas_grupos", schema = "maestros", uniqueConstraints = @UniqueConstraint(columnNames = {
		"nro_documento", "id_grupo" }))
public class PersonasGrupos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7673331185457670374L;
	private long idPersonasGrp;
	private Personas personas;
	private Grupo grupo;
	private String observaciones;
	private String rol;
	private Set<Notas> notases = new HashSet<Notas>(0);
	private Set<AsignaturaPersonasGrupo> asignaturaPersonasGrupos = new HashSet<AsignaturaPersonasGrupo>(
			0);
	private Set<ActividadesGrupo> actividadesGrupos = new HashSet<ActividadesGrupo>(
			0);

	public PersonasGrupos() {
	}

	public PersonasGrupos(long idPersonasGrp, Personas personas, Grupo grupo) {
		this.idPersonasGrp = idPersonasGrp;
		this.personas = personas;
		this.grupo = grupo;
	}

	public PersonasGrupos(long idPersonasGrp, Personas personas, Grupo grupo,
			String observaciones, String rol, Set<Notas> notases,
			Set<AsignaturaPersonasGrupo> asignaturaPersonasGrupos,
			Set<ActividadesGrupo> actividadesGrupos) {
		this.idPersonasGrp = idPersonasGrp;
		this.personas = personas;
		this.grupo = grupo;
		this.observaciones = observaciones;
		this.rol = rol;
		this.notases = notases;
		this.asignaturaPersonasGrupos = asignaturaPersonasGrupos;
		this.actividadesGrupos = actividadesGrupos;
	}

	@Id
	@Column(name = "id_personas_grp", unique = true, nullable = false)
	public long getIdPersonasGrp() {
		return this.idPersonasGrp;
	}

	public void setIdPersonasGrp(long idPersonasGrp) {
		this.idPersonasGrp = idPersonasGrp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nro_documento", nullable = false)
	public Personas getPersonas() {
		return this.personas;
	}

	public void setPersonas(Personas personas) {
		this.personas = personas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo", nullable = false)
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "rol", length = 100)
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personasGrupos")
	public Set<Notas> getNotases() {
		return this.notases;
	}

	public void setNotases(Set<Notas> notases) {
		this.notases = notases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personasGrupos")
	public Set<AsignaturaPersonasGrupo> getAsignaturaPersonasGrupos() {
		return this.asignaturaPersonasGrupos;
	}

	public void setAsignaturaPersonasGrupos(
			Set<AsignaturaPersonasGrupo> asignaturaPersonasGrupos) {
		this.asignaturaPersonasGrupos = asignaturaPersonasGrupos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personasGrupos")
	public Set<ActividadesGrupo> getActividadesGrupos() {
		return this.actividadesGrupos;
	}

	public void setActividadesGrupos(Set<ActividadesGrupo> actividadesGrupos) {
		this.actividadesGrupos = actividadesGrupos;
	}

}
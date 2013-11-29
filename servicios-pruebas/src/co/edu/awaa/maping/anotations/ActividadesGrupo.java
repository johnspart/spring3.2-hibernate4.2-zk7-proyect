package co.edu.awaa.maping.anotations;

// Generated Nov 29, 2013 10:36:17 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ActividadesGrupo generated by hbm2java
 */
@Entity
@Table(name = "actividades_grupo", schema = "maestros")
public class ActividadesGrupo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3139706317546676413L;

	@Id
	@Column(name = "id_tipo_actividad", unique = true, nullable = false)
	private Long idTipoActividad;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_actividad", nullable = false)
	private Actividades actividades;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona_grp", nullable = false)
	private PersonasGrupos personasGrupos;

	public ActividadesGrupo() {
	}

	public ActividadesGrupo(Long idTipoActividad, Actividades actividades,
			PersonasGrupos personasGrupos) {
		this.idTipoActividad = idTipoActividad;
		this.actividades = actividades;
		this.personasGrupos = personasGrupos;
	}

	public Long getIdTipoActividad() {
		return this.idTipoActividad;
	}

	public void setIdTipoActividad(Long idTipoActividad) {
		this.idTipoActividad = idTipoActividad;
	}

	public Actividades getActividades() {
		return this.actividades;
	}

	public void setActividades(Actividades actividades) {
		this.actividades = actividades;
	}

	public PersonasGrupos getPersonasGrupos() {
		return this.personasGrupos;
	}

	public void setPersonasGrupos(PersonasGrupos personasGrupos) {
		this.personasGrupos = personasGrupos;
	}

}

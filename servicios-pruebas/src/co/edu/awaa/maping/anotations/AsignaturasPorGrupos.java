package co.edu.awaa.maping.anotations;

// Generated Nov 29, 2013 10:36:17 AM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AsignaturasPorGrupos generated by hbm2java
 */
@Entity
@Table(name = "asignaturas_por_grupos", schema = "maestros")
public class AsignaturasPorGrupos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3278698967117716786L;
	private AsignaturasPorGruposId id;
	private HorarioAsignatura horarioAsignatura;
	private Grupo grupo;
	private String observacion;

	public AsignaturasPorGrupos() {
	}

	public AsignaturasPorGrupos(AsignaturasPorGruposId id,
			HorarioAsignatura horarioAsignatura, Grupo grupo) {
		this.id = id;
		this.horarioAsignatura = horarioAsignatura;
		this.grupo = grupo;
	}

	public AsignaturasPorGrupos(AsignaturasPorGruposId id,
			HorarioAsignatura horarioAsignatura, Grupo grupo, String observacion) {
		this.id = id;
		this.horarioAsignatura = horarioAsignatura;
		this.grupo = grupo;
		this.observacion = observacion;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idGrupo", column = @Column(name = "id_grupo", nullable = false)),
			@AttributeOverride(name = "idHorarioAsignatura", column = @Column(name = "id_horario_asignatura", nullable = false)) })
	public AsignaturasPorGruposId getId() {
		return this.id;
	}

	public void setId(AsignaturasPorGruposId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_horario_asignatura", nullable = false, insertable = false, updatable = false)
	public HorarioAsignatura getHorarioAsignatura() {
		return this.horarioAsignatura;
	}

	public void setHorarioAsignatura(HorarioAsignatura horarioAsignatura) {
		this.horarioAsignatura = horarioAsignatura;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo", nullable = false, insertable = false, updatable = false)
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Column(name = "observacion")
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
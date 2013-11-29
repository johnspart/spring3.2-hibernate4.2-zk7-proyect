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
 * PropietarioAsignatura generated by hbm2java
 */
@Entity
@Table(name = "propietario_asignatura", schema = "propietarios")
public class PropietarioAsignatura implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5314352024815683922L;
	private long idProAsignatura;
	private Usuarios usuarios;
	private Asignatura asignatura;

	public PropietarioAsignatura() {
	}

	public PropietarioAsignatura(long idProAsignatura) {
		this.idProAsignatura = idProAsignatura;
	}

	public PropietarioAsignatura(long idProAsignatura, Usuarios usuarios,
			Asignatura asignatura) {
		this.idProAsignatura = idProAsignatura;
		this.usuarios = usuarios;
		this.asignatura = asignatura;
	}

	@Id
	@Column(name = "id_pro_asignatura", unique = true, nullable = false)
	public long getIdProAsignatura() {
		return this.idProAsignatura;
	}

	public void setIdProAsignatura(long idProAsignatura) {
		this.idProAsignatura = idProAsignatura;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_asignatura")
	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

}
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
 * PaginasContenido generated by hbm2java
 */
@Entity
@Table(name = "paginas_contenido", schema = "blog")
public class PaginasContenido implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2364353221265904741L;
	private long idPagContenido;
	private Contenido contenido;
	private Grupo grupo;
	private String cuerpoHtml;
	private Boolean interna;

	public PaginasContenido() {
	}

	public PaginasContenido(long idPagContenido, Contenido contenido) {
		this.idPagContenido = idPagContenido;
		this.contenido = contenido;
	}

	public PaginasContenido(long idPagContenido, Contenido contenido,
			Grupo grupo, String cuerpoHtml, Boolean interna) {
		this.idPagContenido = idPagContenido;
		this.contenido = contenido;
		this.grupo = grupo;
		this.cuerpoHtml = cuerpoHtml;
		this.interna = interna;
	}

	@Id
	@Column(name = "id_pag_contenido", unique = true, nullable = false)
	public long getIdPagContenido() {
		return this.idPagContenido;
	}

	public void setIdPagContenido(long idPagContenido) {
		this.idPagContenido = idPagContenido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contenido", nullable = false)
	public Contenido getContenido() {
		return this.contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo")
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Column(name = "cuerpo_html")
	public String getCuerpoHtml() {
		return this.cuerpoHtml;
	}

	public void setCuerpoHtml(String cuerpoHtml) {
		this.cuerpoHtml = cuerpoHtml;
	}

	@Column(name = "interna")
	public Boolean getInterna() {
		return this.interna;
	}

	public void setInterna(Boolean interna) {
		this.interna = interna;
	}

}

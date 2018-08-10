package mx.com.xisco.persistence.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notificacion")
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_notificacion")
	private Integer id;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, unique = true, nullable = false)
	private String titulo;

	@NotNull
	@Size(min = 1, max = 1000)
	@Column(length = 1000, columnDefinition = "text", nullable = false)
	private String descripcion;

	@NotNull
	@Column(nullable = false)
	private Instant fechaExposicionInicial;

	@NotNull
	@Column(nullable = false)
	private Instant fechaExposicionFinal;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bien_inmueble", referencedColumnName="id_bien_inmueble", nullable = false)
	private BienInmueble bienInmueble;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Instant getFechaExposicionInicial() {
		return fechaExposicionInicial;
	}

	public void setFechaExposicionInicial(Instant fechaExposicionInicial) {
		this.fechaExposicionInicial = fechaExposicionInicial;
	}

	public Instant getFechaExposicionFinal() {
		return fechaExposicionFinal;
	}

	public void setFechaExposicionFinal(Instant fechaExposicionFinal) {
		this.fechaExposicionFinal = fechaExposicionFinal;
	}

	public BienInmueble getBienInmueble() {
		return bienInmueble;
	}

	public void setBienInmueble(BienInmueble bienInmueble) {
		this.bienInmueble = bienInmueble;
	}
	
	

}

package mx.com.xisco.persistence.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "colonias")
public class Colonia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_colonia")
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String codigoPostal;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zona", referencedColumnName="id_zona")
	private Zona zona;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio_delegacion", referencedColumnName="id_municipio_delegacion")
	private MunicipioDelegacion municipioDelegacion;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "colonia")
	private Collection<Direccion> direcciones;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Collection<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Collection<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	
}

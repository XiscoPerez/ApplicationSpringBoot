package mx.com.xisco.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "direcciones")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion")
	private Long id;

	@NotNull
	@Size(min = 1, max = 5)
	@Column(length = 5, nullable = false)
	private String codigoPostal;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String calle;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String numeroExterior;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50)
	private String numeroInterior;

	@NotNull
	@Size(min = 1, max = 200)
	@Column(length = 50)
	private String entreCalles;

	@NotNull
	@Size(min = 1, max = 500)
	@Column(length = 500, columnDefinition = "text")
	private String referencias;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colonia", referencedColumnName = "id_colonia", nullable = false)
	private Colonia colonia;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direccion")
	private Usuario usuario;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direccion")
	private BienInmueble bienInmueble;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direccion")
	private Sucursal sucursal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public String getEntreCalles() {
		return entreCalles;
	}

	public void setEntreCalles(String entreCalles) {
		this.entreCalles = entreCalles;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public Usuario getUsuairo() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BienInmueble getBienInmueble() {
		return bienInmueble;
	}

	public void setBienInmueble(BienInmueble bienInmueble) {
		this.bienInmueble = bienInmueble;
	}

	public Colonia getColonia() {
		return colonia;
	}

	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}

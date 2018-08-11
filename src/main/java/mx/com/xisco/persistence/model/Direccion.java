package mx.com.xisco.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_direccion")
	private Integer id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, unique = true, nullable = false)
	private String colonia;
	
	@NotNull
	@Size(min = 1, max = 5)
	@Column(length = 5, unique = true, nullable = false)
	private String codigoPostal;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, unique = true, nullable = false)
	private String calle;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String numero;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String interior;
	
	@NotNull
	@Size(min = 1, max = 200)
	@Column(length = 50, unique = true, nullable = false)
	private String entreCalles;
	
	@NotNull
	@Size(min = 1, max = 500)
	@Column(length = 500, columnDefinition = "text", nullable = false)
	private String referencias;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", referencedColumnName="id_estado", nullable = false)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio_delegacion", referencedColumnName="id_municipio_delegacion", nullable = false)
	private MunicipioDelegacion municipioDelegacion;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "direccion")
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "direccion")
	private BienInmueble bienInmueble;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "direccion")
	private Sucursal sucursal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public MunicipioDelegacion getMunicipioDelegacion() {
		return municipioDelegacion;
	}

	public void setMunicipioDelegacion(MunicipioDelegacion municipioDelegacion) {
		this.municipioDelegacion = municipioDelegacion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BienInmueble getBienInmueble() {
		return bienInmueble;
	}

	public void setBienInmueble(BienInmueble bienInmueble) {
		this.bienInmueble = bienInmueble;
	}
	
	
	
	
	

}

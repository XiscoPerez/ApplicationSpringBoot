package mx.com.xisco.persistence.model;

import java.math.BigDecimal;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bien_inmueble")
public class BienInmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bien_inmueble")
	private Integer id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String nombre;
	
	@Min(value = 1)
	@Max(value = 31)
	@Size(min = 1, max = 31)
	@Column(nullable= false) 
	private Integer diaCuotaOrdinaria;
	
	@Digits(integer=5, fraction=2)
	@Column(nullable= false, precision=5, scale=2) 
	private BigDecimal montoCuotaOrdinaria;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String imagenUrl;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String nombreResponsable;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String nombreAsociacion;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String rfc;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String telefonoAsociacion;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String correoAsociacion;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String numCuentaAsociacion;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_direccion", referencedColumnName="id_direccion", nullable = false)
	private Direccion direccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colonia", referencedColumnName="id_colonia", nullable = false)
	private Colonia colonia;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName="id", nullable = false)
	private User administrador;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bienInmueble")
	private List<Notificacion> notificaciones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDiaCuotaOrdinaria() {
		return diaCuotaOrdinaria;
	}

	public void setDiaCuotaOrdinaria(Integer diaCuotaOrdinaria) {
		this.diaCuotaOrdinaria = diaCuotaOrdinaria;
	}

	public BigDecimal getMontoCuotaOrdinaria() {
		return montoCuotaOrdinaria;
	}

	public void setMontoCuotaOrdinaria(BigDecimal montoCuotaOrdinaria) {
		this.montoCuotaOrdinaria = montoCuotaOrdinaria;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getNombreResponsable() {
		return nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	public String getNombreAsociacion() {
		return nombreAsociacion;
	}

	public void setNombreAsociacion(String nombreAsociacion) {
		this.nombreAsociacion = nombreAsociacion;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getTelefonoAsociacion() {
		return telefonoAsociacion;
	}

	public void setTelefonoAsociacion(String telefonoAsociacion) {
		this.telefonoAsociacion = telefonoAsociacion;
	}

	public String getCorreoAsociacion() {
		return correoAsociacion;
	}

	public void setCorreoAsociacion(String correoAsociacion) {
		this.correoAsociacion = correoAsociacion;
	}

	public String getNumCuentaAsociacion() {
		return numCuentaAsociacion;
	}

	public void setNumCuentaAsociacion(String numCuentaAsociacion) {
		this.numCuentaAsociacion = numCuentaAsociacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Colonia getColonia() {
		return colonia;
	}

	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}

	public User getAdministrador() {
		return administrador;
	}

	public void setAdministrador(User administrador) {
		this.administrador = administrador;
	}

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	
	
	

}

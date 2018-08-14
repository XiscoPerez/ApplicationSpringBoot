package mx.com.xisco.persistence.model;

import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bienes_inmuebles")
public class BienInmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bien_inmueble")
	private Long id;

	@NotNull
	@Size(min = 1, max = 200)
	@Column(length = 200, unique = true, nullable = false)
	private String nombre;
	
	@Min(value = 1)
	@Max(value = 31)
	@Column(nullable= false) 
	private Integer diaCuotaOrdinaria;
	
	@Digits(integer=5, fraction=2)
	@Column(nullable= false, precision=5, scale=2) 
	private BigDecimal montoCuotaOrdinaria;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String imagenUrl;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_direccion", referencedColumnName="id_direccion", nullable = false)
	private Direccion direccion;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName="id_usuario", nullable = false)
	private Usuario administrador;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bienInmueble")
	private Collection<Notificacion> notificaciones;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_datos_adicionales", referencedColumnName="id_datos_adicionales")
    private DatosAdicionales datosAdicionales;

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


	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	public Collection<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Collection<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public DatosAdicionales getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(DatosAdicionales datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

}

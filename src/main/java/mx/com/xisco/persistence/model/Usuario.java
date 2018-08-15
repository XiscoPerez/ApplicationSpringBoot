package mx.com.xisco.persistence.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the users database table.
 *
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String usuario;

    private String nombre;

    private String apellidoPatarno;
    
    private String apellidoMaterno;

    private String correo;

    @Column(name = "cuenta_expirada")
    private boolean cuentaExpirada;

    @Column(name = "cuenta_bloqueada")
    private boolean cuentaBloqueada;

    @Column(name = "credenciales_expiradas")
    private boolean credencialesExpiradas;

    private final boolean activo;

    private String identificador;

    private String contrasenia;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Rol> roles;
    
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "usuario")
    private Zona zona;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarioAsignado")
    private Collection<Ticket> tickets;
    
    
    //Proveedor
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_datos_adicionales", referencedColumnName="id_datos_adicionales")
    private DatosAdicionales datosAdicionales;
    
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_direccion", referencedColumnName="id_direccion", nullable = false)
    private Direccion direccion;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private Collection<Telefono> telefonos;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_areas_servicios", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_area_servicio", referencedColumnName = "id_area_servicio"))
    private Collection<AreaServicio> areasServicios;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private Collection<Comentario> comentarios;
    
    //administrador
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "administrador")
    private BienInmueble bienInmueble;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private Collection<Pago> pagos;
    

    public Usuario() {
        activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPatarno() {
		return apellidoPatarno;
	}

	public void setApellidoPatarno(String apellidoPatarno) {
		this.apellidoPatarno = apellidoPatarno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isCuentaExpirada() {
		return cuentaExpirada;
	}

	public void setCuentaExpirada(boolean cuentaExpirada) {
		this.cuentaExpirada = cuentaExpirada;
	}

	public boolean isCuentaBloqueada() {
		return cuentaBloqueada;
	}

	public void setCuentaBloqueada(boolean cuentaBloqueada) {
		this.cuentaBloqueada = cuentaBloqueada;
	}

	public boolean isCredencialesExpiradas() {
		return credencialesExpiradas;
	}

	public void setCredencialesExpiradas(boolean credencialesExpiradas) {
		this.credencialesExpiradas = credencialesExpiradas;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public boolean isActivo() {
		return activo;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Collection<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}


	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Collection<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Collection<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Collection<AreaServicio> getAreasServicios() {
		return areasServicios;
	}

	public void setAreasServicios(Collection<AreaServicio> areasServicios) {
		this.areasServicios = areasServicios;
	}


	public DatosAdicionales getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(DatosAdicionales datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}

	public BienInmueble getBienInmueble() {
		return bienInmueble;
	}

	public void setBienInmueble(BienInmueble bienInmueble) {
		this.bienInmueble = bienInmueble;
	}
    
}
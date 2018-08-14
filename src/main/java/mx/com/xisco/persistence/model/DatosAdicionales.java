package mx.com.xisco.persistence.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "datos_adicionales")
public class DatosAdicionales {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_datos_adicionales")
		private Long id;
	    
	    @NotNull
		@Size(min = 1, max = 200)
		@Column(length = 200, nullable = false)
		private String nombreRepresentante;
		
		@NotNull
		@Size(min = 1, max = 200)
		@Column(length = 200, nullable = false)
		private String razonSocial;
		
		@NotNull
		@Size(min = 1, max = 13)
		@Column(length = 13, nullable = false)
		private String rfc;
		
		@NotNull
		@Size(min = 1, max = 50)
		@Column(length = 50, nullable = false)
		private String telefono;
		
		@NotNull
		@Size(min = 1, max = 100)
		@Column(length = 100, nullable = false)
		private String correo;
		
		@NotNull
		@Size(min = 1, max = 50)
		@Column(length = 50, nullable = false)
		private String numeroCuenta;
		
		@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "datosAdicionales")
		private Usuario usuario;
		
		@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "datosAdicionales")
		private BienInmueble bienInmueble;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombreRepresentante() {
			return nombreRepresentante;
		}

		public void setNombreRepresentante(String nombreRepresentante) {
			this.nombreRepresentante = nombreRepresentante;
		}

		public String getRazonSocial() {
			return razonSocial;
		}

		public void setRazonSocial(String razonSocial) {
			this.razonSocial = razonSocial;
		}

		public String getRfc() {
			return rfc;
		}

		public void setRfc(String rfc) {
			this.rfc = rfc;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getNumeroCuenta() {
			return numeroCuenta;
		}

		public void setNumeroCuenta(String numeroCuenta) {
			this.numeroCuenta = numeroCuenta;
		}

		public Usuario getUsuario() {
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

}

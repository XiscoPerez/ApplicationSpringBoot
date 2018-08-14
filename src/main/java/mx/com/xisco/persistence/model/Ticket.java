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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ticket")
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String titulo;
	
	@NotNull
	@Size(min = 1, max = 4000)
	@Column(length = 4000, columnDefinition = "text", nullable = false)
	private String descripcion;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estatus_ticket", referencedColumnName="id_estatus_ticket", nullable = false)
	private EstatusTicket estatusTicket;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_ticket", referencedColumnName="id_tipo_ticket", nullable = false)
	private TipoTicket tipoTicket;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName="id_usuario", nullable = false)
	private Usuario usuarioAsignado;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ticket")
	private Collection<CambioTicket> cambios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public EstatusTicket getEstatusTicket() {
		return estatusTicket;
	}

	public void setEstatusTicket(EstatusTicket estatusTicket) {
		this.estatusTicket = estatusTicket;
	}

	public TipoTicket getTipoTicket() {
		return tipoTicket;
	}

	public void setTipoTicket(TipoTicket tipoTicket) {
		this.tipoTicket = tipoTicket;
	}

	public Usuario getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(Usuario usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	public Collection<CambioTicket> getCambios() {
		return cambios;
	}

	public void setCambios(Collection<CambioTicket> cambios) {
		this.cambios = cambios;
	}

}

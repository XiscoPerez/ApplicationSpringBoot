package mx.com.xisco.persistence.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ticket")
	private Integer id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String titulo;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estatus_ticket", referencedColumnName="id_estatus_ticket", nullable = false)
	private EstatusTicket estatusTicket;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_ticket", referencedColumnName="id_tipo_ticket", nullable = false)
	private TipoTicket tipoTicket;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName="id", nullable = false)
	private User usuarioAsignado;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ticket")
	private List<Comentario> comentarios;

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

	public User getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(User usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	

}

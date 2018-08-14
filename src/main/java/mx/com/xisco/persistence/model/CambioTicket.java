package mx.com.xisco.persistence.model;

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
@Table(name = "cambios_ticket")
public class CambioTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cambio_ticket")
	private Long id;

	@NotNull
	@Size(min = 1, max = 4000)
	@Column(length = 4000, columnDefinition = "text", nullable = false)
	private String comentario;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String evidenciaImagenUrl;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estatus_ticket", referencedColumnName = "id_estatus_ticket", nullable = false)
	private EstatusTicket estatusTicket;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket", nullable = false)
	private Ticket ticket;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEvidenciaImagenUrl() {
		return evidenciaImagenUrl;
	}

	public void setEvidenciaImagenUrl(String evidenciaImagenUrl) {
		this.evidenciaImagenUrl = evidenciaImagenUrl;
	}

	public EstatusTicket getEstatusTicket() {
		return estatusTicket;
	}

	public void setEstatusTicket(EstatusTicket estatusTicket) {
		this.estatusTicket = estatusTicket;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuairo(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}

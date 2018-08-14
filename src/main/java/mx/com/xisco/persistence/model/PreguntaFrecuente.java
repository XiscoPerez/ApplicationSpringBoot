package mx.com.xisco.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "preguntas_frecuentes")
public class PreguntaFrecuente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pregunta_frecuente")
	private Long id;

	@NotNull
	@Size(min = 1, max = 500)
	@Column(length = 500, columnDefinition = "text", nullable = false)
	private String pregunta;
	
	@NotNull
	@Size(min = 1, max = 2000)
	@Column(length = 2000, columnDefinition = "text", nullable = false)
	private String respuesta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	

}

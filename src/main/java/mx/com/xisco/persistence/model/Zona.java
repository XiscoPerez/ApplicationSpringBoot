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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "zona")
public class Zona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_zona")
	private Integer id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String codigo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "zona")
	private List<Colonia> colonias;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", referencedColumnName="id", nullable = false)
    private User user;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Colonia> getColonias() {
		return colonias;
	}

	public void setColonias(List<Colonia> colonias) {
		this.colonias = colonias;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}

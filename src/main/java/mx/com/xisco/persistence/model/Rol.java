package mx.com.xisco.persistence.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the roles database table.
 *
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String descripcion;

    private boolean activo;

    @ManyToMany(mappedBy = "roles")
    private Collection<Usuario> usuarios;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_privilegios", joinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_privilegio", referencedColumnName = "id"))
    private Collection<Privilegio> privilegios;

    public Rol() {
    	activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(Collection<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

	public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "asentamientos")
public class Asentamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asentamiento")
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, nullable = false)
    private String codigoPostal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_asentamiento", referencedColumnName = "id_tipo_asentamiento")
    private TipoAsentamiento tipoAsentamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
    private Zona zona;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "asentamiento")
    private Collection<Direccion> direcciones;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(final String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(final Zona zona) {
        this.zona = zona;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(final Municipio municipio) {
        this.municipio = municipio;
    }

    public Collection<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(final Collection<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

}

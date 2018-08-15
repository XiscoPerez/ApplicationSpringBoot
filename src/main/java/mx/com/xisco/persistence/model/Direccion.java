package mx.com.xisco.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id;

    @NotNull
    @Size(min = 1, max = 5)
    @Column(length = 5, nullable = false)
    private String codigoPostal;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, nullable = false)
    private String calle;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, nullable = false)
    private String numeroExterior;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50)
    private String numeroInterior;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(length = 50)
    private String entreCalles;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(length = 500, columnDefinition = "text")
    private String referencias;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asentamiento", referencedColumnName = "id_asentamiento", nullable = false)
    private Asentamiento asentamiento;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direccion")
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direccion")
    private BienInmueble bienInmueble;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direccion")
    private Sucursal sucursal;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(final String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(final String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(final String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(final String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getEntreCalles() {
        return entreCalles;
    }

    public void setEntreCalles(final String entreCalles) {
        this.entreCalles = entreCalles;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(final String referencias) {
        this.referencias = referencias;
    }

    public Asentamiento getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(final Asentamiento asentamiento) {
        this.asentamiento = asentamiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(final Usuario usuario) {
        this.usuario = usuario;
    }

    public BienInmueble getBienInmueble() {
        return bienInmueble;
    }

    public void setBienInmueble(final BienInmueble bienInmueble) {
        this.bienInmueble = bienInmueble;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(final Sucursal sucursal) {
        this.sucursal = sucursal;
    }

}

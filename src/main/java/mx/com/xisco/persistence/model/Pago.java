package mx.com.xisco.persistence.model;

import java.math.BigDecimal;

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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pago")
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pago")
	private Integer id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String numeroTransaccion;
	
	@Digits(integer=7, fraction=2)
	@Column(nullable= false, precision=7, scale=2)
	private BigDecimal monto;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String concepto;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	private String comprobantePagoUrl;
	
	@NotNull
	private Boolean verificado;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_pago_bancario", referencedColumnName="id_tipo_pago_bancario", nullable = false)
	private TipoPagoBancario tipoPagoBancario;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_pago", referencedColumnName="id_tipo_pago", nullable = false)
	private TipoPago tipoPago;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(String numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getComprobantePagoUrl() {
		return comprobantePagoUrl;
	}

	public void setComprobantePagoUrl(String comprobantePagoUrl) {
		this.comprobantePagoUrl = comprobantePagoUrl;
	}

	public Boolean getVerificado() {
		return verificado;
	}

	public void setVerificado(Boolean verificado) {
		this.verificado = verificado;
	}

	public TipoPagoBancario getTipoPagoBancario() {
		return tipoPagoBancario;
	}

	public void setTipoPagoBancario(TipoPagoBancario tipoPagoBancario) {
		this.tipoPagoBancario = tipoPagoBancario;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	

}

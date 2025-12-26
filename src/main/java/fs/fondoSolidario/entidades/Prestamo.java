package fs.fondoSolidario.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import org.hibernate.annotations.GenericGenerator;

@Entity


public class Prestamo {
	
	@Id 
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")   
	private String idprestamo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_prestamo;

	@ManyToOne
	private Socio socio;
	private Integer montoSolicitado;
	private Integer cantCuotas;
	private Integer tasaInteres;
	private Integer valorIntereses;
	private Integer valorTotal;
    private Integer valorCuota;
	private Integer numeroCuota;
	private Double saldo;
	private Boolean activo;
   

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getIdprestamo() {
		return idprestamo;
	}

	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public Socio getSocio() {
		return socio;
	}

	public Integer getMontoSolicitado() {
		return montoSolicitado;
	}

	public Integer getCantCuotas() {
		return cantCuotas;
	}

	public Integer getTasaInteres() {
		return tasaInteres;
	}

	public Integer getValorIntereses() {
		return valorIntereses;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public Integer getValorCuota() {
		return valorCuota;
	}

	public Integer getNumeroCuota() {
		return numeroCuota;
	}

	public Double getSaldo() {
		return saldo;
	}

	

	public void setIdprestamo(String idprestamo) {
		this.idprestamo = idprestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public void setMontoSolicitado(Integer montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public void setCantCuotas(Integer cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public void setTasaInteres(Integer tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public void setValorIntereses(Integer valorIntereses) {
		this.valorIntereses = valorIntereses;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setValorCuota(Integer valorCuota) {
		this.valorCuota = valorCuota;
	}

	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	
}

package fs.fondoSolidario.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Socio {

@Id 
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")   
private String idsocio;

private String nombre;
private String apellido;
private String dni;
private String matricula;
private String telefono;
private String tipoUsuario;


@Temporal(TemporalType.DATE)
private Date fecha_ingreso;

@Temporal(TemporalType.DATE)
private Date fecha_alta;

@Temporal(TemporalType.DATE)
private Date fecha_baja;

private Boolean activo;


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}

public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public Date getFecha_alta() {
	return fecha_alta;
}
public void setFecha_alta(Date fecha_alta) {
	this.fecha_alta = fecha_alta;
}
public Date getFecha_baja() {
	return fecha_baja;
}
public void setFecha_baja(Date fecha_baja) {
	this.fecha_baja = fecha_baja;
}
public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public Date getFecha_ingreso() {
	return fecha_ingreso;
}
public void setFecha_ingreso(Date fecha_ingreso) {
	this.fecha_ingreso = fecha_ingreso;
}
public String getIdsocio() {
	return idsocio;
}
public void setIdsocio(String idsocio) {
	this.idsocio = idsocio;
}
public Boolean getActivo() {
	return activo;
}
public void setActivo(Boolean activo) {
	this.activo = activo;
}

public String getTipoUsuario() {
	return tipoUsuario;
}


public void setTipoUsuario(String tipoUsuario) {
	this.tipoUsuario = tipoUsuario;
}



}

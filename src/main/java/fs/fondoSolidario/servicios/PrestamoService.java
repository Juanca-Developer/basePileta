package fs.fondoSolidario.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fs.fondoSolidario.entidades.Prestamo;
import fs.fondoSolidario.entidades.Socio;
import fs.fondoSolidario.repositorios.PrestamoRepository;
import fs.fondoSolidario.repositorios.SocioRepository;



@Service
public class PrestamoService {
	
@Autowired
private PrestamoRepository prestamoRepository;

@Autowired
private SocioRepository socioRepository;
	
	
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
public void liquidar(String idsocio, Integer montoSolicitado, Integer cantCuotas, Integer tasaInteres,Integer valorIntereses, Integer ValorTotal) throws Exception {

validar(idsocio, montoSolicitado, cantCuotas,tasaInteres,valorIntereses,ValorTotal);

		                
Prestamo prestamo = new Prestamo();

prestamo.setFecha_prestamo(new Date());
prestamo.setSocio(socioRepository.findById(idsocio).get());
prestamo.setMontoSolicitado(montoSolicitado);
prestamo.setCantCuotas(cantCuotas);
prestamo.setTasaInteres(tasaInteres);
prestamo.setValorIntereses(valorIntereses);
prestamo.setValorTotal(montoSolicitado*tasaInteres);

prestamoRepository.save(prestamo);      
 
		                
				
			
}
/* @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
public void registrarCuotas(String idprestamo, Integer importe, Integer cant_cuotas, Integer tasa_interes, Integer valor_intereses,Integer valor_total) throws Exception {



Prestamo prestamo = prestamoRepository.getById(idprestamo);

prestamo.setValorTotal(valor_total);
prestamo.setCantCuotas(cant_cuotas);
prestamo.setValor_total(valor_total-importe);
prestamo.setFecha_prestamo(new Date());
prestamo.setImporte(importe);

prestamo.setTasa_interes(tasa_interes);
valor_intereses = (importe*tasa_interes)/100;
prestamo.setValor_intereses(valor_intereses);
valor_total = (importe+prestamo.getValor_intereses());
prestamo.setValor_total(valor_total);

prestamoRepository.save(prestamo);



} */
@Transactional(readOnly = true)
public List<Prestamo> listarTodos() {
	return prestamoRepository.findAll();
}  



public void validar(String idsocio, Integer montoSolicitado, Integer cantCuotas, Integer tasaInteres, Integer valorIntereses, Integer valorTotal) throws Exception {

	if (idsocio == null || idsocio.isEmpty() || idsocio.contains("  ")) {
		throw new Exception();
	}
	
	if (montoSolicitado == null || montoSolicitado.toString().isEmpty() || montoSolicitado.toString().contains("  ")) {
		throw new Exception();
	}
	
	if (cantCuotas == null || cantCuotas.toString().isEmpty() || cantCuotas.toString().contains("  ")) {
		throw new Exception();
	}
	
	if (tasaInteres == null || tasaInteres.toString().isEmpty() || tasaInteres.toString().contains("  ")) {
		throw new Exception();
	}
	if (valorIntereses == null || valorIntereses.toString().isEmpty() || valorIntereses.toString().contains("  ")) {
		throw new Exception();
	}
	if (valorTotal == null || valorTotal.toString().isEmpty() || valorTotal.toString().contains("  ")) {
		throw new Exception();
	}
	
	
}

}

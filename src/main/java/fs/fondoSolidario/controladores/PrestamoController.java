package fs.fondoSolidario.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fs.fondoSolidario.entidades.Prestamo;
import fs.fondoSolidario.entidades.Socio;

import fs.fondoSolidario.repositorios.SocioRepository;
import fs.fondoSolidario.servicios.PrestamoService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/prestamo")
public class PrestamoController {
	
	
	@Autowired
	private PrestamoService prestamoService;
	
	
	@Autowired
	private SocioRepository socioRepository;

   
	
	@GetMapping("/lista")
	public String lista(ModelMap modelo) {
		
		List<Prestamo> todos = prestamoService.listarTodos();
		
		modelo.addAttribute("prestamos", todos);
		
		return "list-prestamos.html";
	}
	
	@GetMapping("/registro")
	public String formulario(ModelMap modelo) {

		List<Socio> socios = socioRepository.findAll();
		modelo.put("socios", socios);
		return "form-prestamo";
	}
	
	@PostMapping("/registro")
	public String registrar(ModelMap model, @RequestParam String idsocio, @RequestParam (name = "montoSolicitado") Integer montoSolicitado, @RequestParam (name ="cantCuotas") Integer cantCuotas, @RequestParam (name= "tasaInteres")Integer tasaInteres, @RequestParam (name = "valorIntereses",required=false) Integer valorIntereses, @RequestParam (required=false) Integer valorTotal) {
		
		try {
			prestamoService.liquidar(idsocio,montoSolicitado,cantCuotas,tasaInteres,valorIntereses,valorTotal);

			model.put("exito", "Registro exitoso");

			return "form-prestamo";
		} catch (Exception e) {

			model.put("error", e.getMessage());
			return "form-prestamo";
		}
	}

}

		
		

		



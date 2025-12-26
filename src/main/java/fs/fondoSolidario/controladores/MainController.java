package fs.fondoSolidario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fs.fondoSolidario.entidades.Socio;
import fs.fondoSolidario.servicios.SocioService;

@Controller
@RequestMapping("/")

public class MainController {
	
	
@Autowired
private SocioService socioService;

@GetMapping("/")
public String index(ModelMap modelo) {
			
List<Socio> sociosActivos = socioService.listarActivos();
			
modelo.addAttribute("socios", sociosActivos);
			
return "index";

		}
		
	}	



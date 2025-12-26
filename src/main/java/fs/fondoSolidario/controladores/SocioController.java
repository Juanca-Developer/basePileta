package fs.fondoSolidario.controladores;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fs.fondoSolidario.entidades.Socio;
import fs.fondoSolidario.repositorios.SocioRepository;
import fs.fondoSolidario.servicios.SocioService;

@Controller
@RequestMapping("/socio")
public class SocioController {
	
	@Autowired
	private SocioService socioService;
	
	@Autowired
	private SocioRepository socioRepository;

	
   
	
	@GetMapping("/lista")
	public String lista(ModelMap modelo) {

		List<Socio> todos = socioService.listarporSocios();
		
			
		modelo.addAttribute("socios", todos);
		
		return "list-socios.html";
	}
	
	@GetMapping("/registro")
	public String formulario(ModelMap modelo) {

		List<Socio> socios = socioRepository.findAll();
		modelo.put("socios", socios);
		return "form-socio";
	}
	
	@PostMapping("/registro")
	public String registrar(ModelMap modelo, @RequestParam( name = "fecha_ingreso", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_ingreso, @RequestParam ("nombre") String nombre, @RequestParam ("apellido") String apellido, @RequestParam("dni") String dni, @RequestParam("matricula") String matricula, @RequestParam("telefono") String telefono, @RequestParam("tipoUsuario") String tipoUsuario) {
		
		try {
			  socioService.guardar(fecha_ingreso, nombre, apellido, dni, matricula, telefono, tipoUsuario);
             
		     modelo.put("exito", "Registro exitoso");

			return "form-socio";
		} catch (Exception e) {

			modelo.put("error",  "Ocurrio algun error- Verifique los datos ingresados");
			return "form-socio";
		}
	}

	@GetMapping("/alta/{id}")
	public String alta(@PathVariable String id) {
		
		try {
			socioService.alta(id);
			return "redirect:/list-socios";
		} catch (Exception e) {
			return "redirect:/";
		}
	}
	
  @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable String idsocio,
                                            @RequestBody Socio socio) {
        // Verifica si el producto existe
        Optional<Socio> socioOptional = this.socioService.getById(id);

        if (socioOptional.isPresent()) {
            Socio existingSocio = socioOptional.get();

            // Actualiza los valores del producto existente con los nuevos datos
            existingSocio.setNombre(socio.getNombre());
            existingSocio.setApellido(socio.getApellido());
			existingSocio.setDni(socio.getDni());
			existingSocio.setMatricula(socio.getMatricula());
			existingSocio.setTelefono(socio.getTelefono());
			existingSocio.setTipoUsuario(socio.getTipoUsuario());
            // Agrega más campos si los hay

            // Llama al servicio para actualizar el producto
            Optional<Socio> Optionalsocio = this.socioService.update(idsocio, existingSocio);

            return ResponseEntity.status(HttpStatus.CREATED).body(Optionalsocio.get());
        }

        // Si el producto no existe, devuelve un 404
        return ResponseEntity.notFound().build();
    }  

   



//Sort sort = Sort.by("matricula").ascending(); // Ordenar por 'nombre' ascendentemente
// O para múltiples campos:
Sort sort = Sort.by("matricula").ascending().and(Sort.by("apellido").ascending());

		
}
		



package fs.fondoSolidario.servicios;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fs.fondoSolidario.entidades.Socio;
import fs.fondoSolidario.repositorios.SocioRepository;

@Service
public class SocioService {

@Autowired
private SocioRepository socioRepository;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
public void guardar(Date fecha_ingreso, String nombre, String apellido, String dni, String matricula, String telefono, String tipoUsuario) throws Exception {

			validar(fecha_ingreso, nombre, apellido, dni, matricula, telefono,tipoUsuario);
	                
	                Socio socio = new Socio();
	                
	                socio.setNombre(nombre);
	                socio.setApellido(apellido);
	                socio.setDni(dni);
	                socio.setMatricula(matricula);
					    
	                socio.setTelefono(telefono);
	                socio.setFecha_ingreso(fecha_ingreso);
	                socio.setFecha_alta(new Date());
	                socio.setTipoUsuario(tipoUsuario);
	               
	                socioRepository.save(socio);
			
		
		}   

 @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Socio alta(String id) {

		Socio entidad = socioRepository.getOne(id);

		entidad.setActivo(true);
		return socioRepository.save(entidad);
	}
	        
	    @Transactional(readOnly = true)
		public List<Socio> listarTodos() {
			return socioRepository.findAll();
		}  
	    
		@Transactional(readOnly = true)
		public List<Socio> listarporSocios() {
		
		return socioRepository.findAll(Sort.by("matricula").ascending().and(Sort.by("apellido").ascending()));
     }


		@Transactional(readOnly = true)
		public List<Socio> listarActivos() {
			return socioRepository.buscarActivos();
		}



   @Override
    @Transactional
    public Optional <Socio> update(String idsocio, Socio socio) {
        Optional<Socio> socio1 = this.getById(id);

        if(socio1.isPresent()){
            // El uso de orElseThrow() para lanzar una excepción en caso de que no se
            // encuentre el producto
            Socio soc = socio1.orElseThrow();

            soc.setNombre(socio.getNombre());
            soc.setApellido(socio.getApellido();
			soc.setDni(socio.getDni());
			soc.setMatricula(socio.getMatricula());
			soc.setTelefono(socio.getTelefono());
			soc.setTipoUsuario(socio.getTipoUsuario());

            return Optional.of(this.socioRepository.save(socio));
        }

        return socio1;
    }
		
	    public void validar( Date fecha_ingreso,String nombre, String apellido, String dni, String matricula,String telefono, String tipoUsuario ) throws Exception {
		
			if (fecha_ingreso == null || fecha_ingreso.toString().isEmpty() || fecha_ingreso.toString().contains("  ")) {
				throw new Exception();
			}
			if (nombre == null || nombre.isEmpty() || nombre.contains("  ")) {
				throw new Exception();
			}
			
			if (apellido == null || apellido.isEmpty() || apellido.contains("  ")) {
				throw new Exception();
			}
			
			if (dni == null || dni.isEmpty() || dni.contains("  ")) {
				throw new Exception();
			}

			
			
			if (matricula == null || matricula.isEmpty() || matricula.contains("  ")) {
				throw new Exception();
			}
			
	        if (telefono == null || telefono.isEmpty() || telefono.contains("  ")) {
				throw new Exception();
			}
			if (tipoUsuario == null || tipoUsuario.isEmpty() || tipoUsuario.contains("  ")) {
				throw new Exception();
			}
	       
		}
	}	
	
	
	


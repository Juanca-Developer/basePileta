package fs.fondoSolidario.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fs.fondoSolidario.entidades.Socio;

@Repository
public interface SocioRepository extends JpaRepository <Socio, String> {
	
@Query("SELECT a from Socio a WHERE a.activo = true ")
public List <Socio> buscarActivos();    	

}

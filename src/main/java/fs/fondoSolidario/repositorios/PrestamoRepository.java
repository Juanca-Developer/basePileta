package fs.fondoSolidario.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fs.fondoSolidario.entidades.Prestamo;


@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,String> {
	
// @Query("SELECT p from Prestamo p WHERE p.estado = true ")
  //public List <Prestamo> buscarActivos(); 

}

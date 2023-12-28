package com.catedra.prueba.Repository;

import com.catedra.prueba.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long>  {

}

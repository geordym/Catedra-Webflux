package com.catedra.prueba.Service;

import com.catedra.prueba.DTO.CursoDTO;
import com.catedra.prueba.Entity.Curso;

import java.util.List;


public interface ICursoService {


    List<CursoDTO> listarCursos();
    CursoDTO crearCurso(CursoDTO cursoDTO);

    void eliminarCurso(Long idCurso);

    CursoDTO obtenerCursoPorId(Long idCurso);
}

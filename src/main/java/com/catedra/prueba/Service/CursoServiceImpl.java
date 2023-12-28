package com.catedra.prueba.Service;

import com.catedra.prueba.DTO.CursoDTO;
import com.catedra.prueba.Entity.Curso;
import com.catedra.prueba.Repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CursoServiceImpl implements ICursoService {


    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CursoDTO> listarCursos() {

        List<Curso> cursos = cursoRepository.findAll();
        List<CursoDTO> cursosDTO = new ArrayList<>();
        cursos.forEach((curso -> {
            cursosDTO.add(new CursoDTO(curso.getId(), curso.getNombre(), curso.getDescripcion()));
        }));
        return cursosDTO;
    }

    @Override
    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        Curso curso = modelMapper.map(cursoDTO, Curso.class);
        Curso cursoCreado = cursoRepository.save(curso);
        return modelMapper.map(cursoCreado, CursoDTO.class);
    }


}

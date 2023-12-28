package com.catedra.prueba.Service;

import com.catedra.prueba.DTO.CursoDTO;
import com.catedra.prueba.Entity.Curso;
import com.catedra.prueba.Repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


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

    @Override
    public void eliminarCurso(Long idCurso) {
        cursoRepository.findById(idCurso).ifPresentOrElse(cursoRepository::delete, ()->{
            throw new NoSuchElementException("El curso con ID " + idCurso + " no fue encontrado");
        });
    }

    @Override
    public CursoDTO obtenerCursoPorId(Long idCurso) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado con ID: " + idCurso));
        return modelMapper.map(curso, CursoDTO.class);
    }

}

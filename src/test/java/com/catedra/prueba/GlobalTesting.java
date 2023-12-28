package com.catedra.prueba;

import com.catedra.prueba.DTO.CursoDTO;
import com.catedra.prueba.Entity.Curso;
import com.catedra.prueba.Repository.CursoRepository;
import com.catedra.prueba.Service.CursoServiceImpl;
import com.catedra.prueba.Service.ICursoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@SpringBootTest
public class GlobalTesting {

    @Autowired
    private ICursoService cursoService;

    @Test
    public void testCrearCurso() {
        // Arrange
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNombre("Nuevo Curso");
        cursoDTO.setDescripcion("Descripción del Nuevo Curso");

        // Act
        CursoDTO nuevoCurso = cursoService.crearCurso(cursoDTO);

        // Assert
        assertNotNull(nuevoCurso);
        assertNotNull(nuevoCurso.getId()); // Asegura que se haya asignado un ID al nuevo curso
        assertEquals("Nuevo Curso", nuevoCurso.getNombre());
        assertEquals("Descripción del Nuevo Curso", nuevoCurso.getDescripcion());
    }

    @Test
    public void testListarCursos() {
        CursoRepository cursoRepositoryMock = Mockito.mock(CursoRepository.class);
        when(cursoRepositoryMock.findAll()).thenReturn(Arrays.asList(new Curso(1L, "Curso 1", "Descripción 1")));
        List<Curso> cursos = cursoRepositoryMock.findAll();

        // Assert
        assertEquals(1, cursos.size());
        assertEquals("Curso 1", cursos.get(0).getNombre());
    }

}

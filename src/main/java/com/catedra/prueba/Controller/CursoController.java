package com.catedra.prueba.Controller;


import com.catedra.prueba.DTO.CursoDTO;
import com.catedra.prueba.Service.CursoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")

public class CursoController {

    @Autowired
    private CursoServiceImpl cursoService;

    @GetMapping
    public ResponseEntity<String> obtenerCursos() {
        String mensaje = "Obteniendo la lista de cursos...";
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crearCurso(@Valid @RequestBody CursoDTO cursoDTO) {
        // Aquí puedes trabajar con el objeto CursoDTO recibido
        CursoDTO curso = cursoService.crearCurso(cursoDTO);
        return ResponseEntity.ok(curso);
    }


}

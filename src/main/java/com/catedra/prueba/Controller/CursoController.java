package com.catedra.prueba.Controller;


import com.catedra.prueba.DTO.CursoDTO;
import com.catedra.prueba.Service.CursoServiceImpl;
import com.catedra.prueba.Service.ICursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")

public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> obtenerCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crearCurso(@Valid @RequestBody CursoDTO cursoDTO) {
        // Aquí puedes trabajar con el objeto CursoDTO recibido
        CursoDTO curso = cursoService.crearCurso(cursoDTO);
        return ResponseEntity.ok(curso);
    }


}

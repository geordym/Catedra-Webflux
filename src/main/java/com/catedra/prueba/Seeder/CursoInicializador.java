package com.catedra.prueba.Seeder;


import com.catedra.prueba.DTO.CursoDTO;
import com.catedra.prueba.Entity.Curso;
import com.catedra.prueba.Service.ICursoService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CursoInicializador implements  CommandLineRunner {
    @Autowired
    private ICursoService cursoService;

    Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        List<CursoDTO> cursos = new ArrayList<>();

        //Generacion de cursos con faker
        for(int i = 0; i < 5; i++){
            cursos.add(new CursoDTO( faker.name().fullName(), faker.lorem().sentence()));
        }
        // Guardar cursos en la base de datos
        cursos.forEach((cursoDTO) -> {
            cursoService.crearCurso(cursoDTO);
        });

    }
}

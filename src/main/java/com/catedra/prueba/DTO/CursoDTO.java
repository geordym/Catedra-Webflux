package com.catedra.prueba.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CursoDTO {

    private Long id;
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 35, message = "El nombre debe tener entre 1 y 35 caracteres")
    private String nombre;

    @NotNull(message = "La descripcion no puede ser nula")
    @Size(min = 1, max = 100, message = "La descripcion debe tener entre 1 y 100 caracteres")
    private String descripcion;

    public CursoDTO() {
    }


    public CursoDTO(Long id, @NotNull(message = "El nombre no puede ser nulo") String nombre, @NotNull(message = "La descripcion no puede ser nula") String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    public CursoDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

package com.example.demo.dto;

import com.example.demo.entity.AuthUser;

public class UserResponseDTO {

    private final long id;
    private final String nombre;
    private final String apellido;
    private final String email;

    public UserResponseDTO( AuthUser authUser){
        this.id = authUser.getId();
        this.nombre = authUser.getNombre();
        this.apellido = authUser.getApellido();
        this.email = authUser.getEmail();
    }

}

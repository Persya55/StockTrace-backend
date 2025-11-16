package com.stocktrack.dto;

import lombok.Data;


@Data
public class UsuarioDTO {
    private Long id;
    private String nombreCompleto;
    private String email;
    // Omitimos el password en la respuesta por seguridad
    private String rol;
    
}

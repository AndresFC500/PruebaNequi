package com.Prueba.Nequi.Dto;

import lombok.Data;

@Data
public class CrearProductoRequest {
    private String nombre;
    private int stock;
    private Long sucursalId;
}

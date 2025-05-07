package com.Prueba.Nequi.Dto;

import lombok.Data;

@Data
public class CrearSucursalRequest {
    private String nombre;
    private Long franquiciaId;
}
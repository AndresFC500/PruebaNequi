package com.Prueba.Nequi.Dto;

import lombok.Data;

import java.util.List;

@Data
public class SucursalDTO {
    private Long id;
    private String nombre;
    private List<ProductoDTO> productos;
}
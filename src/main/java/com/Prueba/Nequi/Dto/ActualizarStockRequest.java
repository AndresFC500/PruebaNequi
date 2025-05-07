package com.Prueba.Nequi.Dto;

import lombok.Data;

@Data
public class ActualizarStockRequest {
    private Long productoId;
    private int nuevoStock;
}

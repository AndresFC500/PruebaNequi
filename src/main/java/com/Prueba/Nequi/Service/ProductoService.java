package com.Prueba.Nequi.Service;

import com.Prueba.Nequi.Dto.ActualizarStockRequest;
import com.Prueba.Nequi.Dto.CrearProductoRequest;
import com.Prueba.Nequi.Dto.ProductoDTO;

import java.util.List;

public interface ProductoService {
    ProductoDTO agregarProducto(CrearProductoRequest request);
    void eliminarProducto(Long id);
    ProductoDTO actualizarStock(ActualizarStockRequest request);
    List<ProductoDTO> productoConMasStockPorSucursal(Long franquiciaId);
    ProductoDTO actualizarNombre(Long id, String nuevoNombre);
}
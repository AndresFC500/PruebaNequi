package com.Prueba.Nequi.Service.impl;

import com.Prueba.Nequi.Dto.ActualizarStockRequest;
import com.Prueba.Nequi.Dto.CrearProductoRequest;
import com.Prueba.Nequi.Dto.ProductoDTO;
import com.Prueba.Nequi.Model.Franquicia;
import com.Prueba.Nequi.Model.Producto;
import com.Prueba.Nequi.Model.Sucursal;
import com.Prueba.Nequi.Repository.FranquiciaRepository;
import com.Prueba.Nequi.Repository.ProductoRepository;
import com.Prueba.Nequi.Repository.SucursalRepository;
import com.Prueba.Nequi.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;
    private final FranquiciaRepository franquiciaRepository;

    @Override
    public ProductoDTO agregarProducto(CrearProductoRequest request) {
        Sucursal sucursal = sucursalRepository.findById(request.getSucursalId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        Producto producto = Producto.builder()
                .nombre(request.getNombre())
                .stock(request.getStock())
                .sucursal(sucursal)
                .build();

        producto = productoRepository.save(producto);
        return toDto(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoDTO actualizarStock(ActualizarStockRequest request) {
        Producto producto = productoRepository.findById(request.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(request.getNuevoStock());
        return toDto(productoRepository.save(producto));
    }

    @Override
    public List<ProductoDTO> productoConMasStockPorSucursal(Long franquiciaId) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        return franquicia.getSucursales().stream()
                .map(sucursal -> sucursal.getProductos().stream()
                        .max(Comparator.comparingInt(Producto::getStock))
                        .orElse(null))
                .filter(p -> p != null)
                .map(this::toDtoWithSucursal)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO actualizarNombre(Long id, String nuevoNombre) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(nuevoNombre);
        return toDto(productoRepository.save(producto));
    }

    private ProductoDTO toDto(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setStock(producto.getStock());
        return dto;
    }

    private ProductoDTO toDtoWithSucursal(Producto producto) {
        ProductoDTO dto = toDto(producto);
        dto.setNombre(dto.getNombre() + " (Sucursal: " + producto.getSucursal().getNombre() + ")");
        return dto;
    }
}
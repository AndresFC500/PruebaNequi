package com.Prueba.Nequi.Controller;

import com.Prueba.Nequi.Dto.ActualizarStockRequest;
import com.Prueba.Nequi.Dto.CrearProductoRequest;
import com.Prueba.Nequi.Dto.ProductoDTO;
import com.Prueba.Nequi.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDTO> agregarProducto(@RequestBody CrearProductoRequest request) {
        return ResponseEntity.ok(productoService.agregarProducto(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/stock")
    public ResponseEntity<ProductoDTO> actualizarStock(@RequestBody ActualizarStockRequest request) {
        return ResponseEntity.ok(productoService.actualizarStock(request));
    }

    @GetMapping("/mayor-stock/franquicia/{franquiciaId}")
    public ResponseEntity<List<ProductoDTO>> productoMayorStock(@PathVariable Long franquiciaId) {
        return ResponseEntity.ok(productoService.productoConMasStockPorSucursal(franquiciaId));
    }

    @PutMapping("/{id}/nombre")
    public ResponseEntity<ProductoDTO> actualizarNombre(@PathVariable Long id, @RequestParam String nuevoNombre) {
        return ResponseEntity.ok(productoService.actualizarNombre(id, nuevoNombre));
    }
}

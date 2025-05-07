package com.Prueba.Nequi.Controller;


import com.Prueba.Nequi.Dto.CrearSucursalRequest;
import com.Prueba.Nequi.Dto.SucursalDTO;
import com.Prueba.Nequi.Service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<SucursalDTO> crearSucursal(@RequestBody CrearSucursalRequest request) {
        return ResponseEntity.ok(sucursalService.agregarSucursal(request));
    }

    @PutMapping("/{id}/nombre")
    public ResponseEntity<SucursalDTO> actualizarNombre(@PathVariable Long id, @RequestParam String nuevoNombre) {
        return ResponseEntity.ok(sucursalService.actualizarNombre(id, nuevoNombre));
    }
}


package com.Prueba.Nequi.Controller;

import com.Prueba.Nequi.Dto.CrearFranquiciaRequest;
import com.Prueba.Nequi.Dto.FranquiciaDTO;
import com.Prueba.Nequi.Service.FranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franquicias")
@RequiredArgsConstructor
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    @PostMapping
    public ResponseEntity<FranquiciaDTO> crearFranquicia(@RequestBody CrearFranquiciaRequest request) {
        return ResponseEntity.ok(franquiciaService.crearFranquicia(request));
    }

    @PutMapping("/{id}/nombre")
    public ResponseEntity<FranquiciaDTO> actualizarNombre(@PathVariable Long id, @RequestParam String nuevoNombre) {
        return ResponseEntity.ok(franquiciaService.actualizarNombre(id, nuevoNombre));
    }
}

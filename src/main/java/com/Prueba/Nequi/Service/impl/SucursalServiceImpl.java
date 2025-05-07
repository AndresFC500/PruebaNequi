package com.Prueba.Nequi.Service.impl;


import com.Prueba.Nequi.Dto.CrearSucursalRequest;
import com.Prueba.Nequi.Dto.SucursalDTO;
import com.Prueba.Nequi.Model.Franquicia;
import com.Prueba.Nequi.Model.Sucursal;
import com.Prueba.Nequi.Repository.FranquiciaRepository;
import com.Prueba.Nequi.Repository.SucursalRepository;
import com.Prueba.Nequi.Service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;
    private final FranquiciaRepository franquiciaRepository;

    @Override
    public SucursalDTO agregarSucursal(CrearSucursalRequest request) {
        Franquicia franquicia = franquiciaRepository.findById(request.getFranquiciaId())
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        Sucursal sucursal = Sucursal.builder()
                .nombre(request.getNombre())
                .franquicia(franquicia)
                .build();
        sucursal = sucursalRepository.save(sucursal);
        SucursalDTO dto = new SucursalDTO();
        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        return dto;
    }

    @Override
    public SucursalDTO actualizarNombre(Long id, String nuevoNombre) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        sucursal.setNombre(nuevoNombre);
        sucursal = sucursalRepository.save(sucursal);

        SucursalDTO dto = new SucursalDTO();
        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        return dto;
    }
}


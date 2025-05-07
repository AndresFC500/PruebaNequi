package com.Prueba.Nequi.Service.impl;

import com.Prueba.Nequi.Dto.CrearFranquiciaRequest;
import com.Prueba.Nequi.Dto.FranquiciaDTO;
import com.Prueba.Nequi.Model.Franquicia;
import com.Prueba.Nequi.Repository.FranquiciaRepository;
import com.Prueba.Nequi.Service.FranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    @Override
    public FranquiciaDTO crearFranquicia(CrearFranquiciaRequest request) {
        Franquicia franquicia = Franquicia.builder()
                .nombre(request.getNombre())
                .build();
        franquicia = franquiciaRepository.save(franquicia);
        return toDto(franquicia);
    }

    @Override
    public List<FranquiciaDTO> listarFranquicias() {
        return franquiciaRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FranquiciaDTO actualizarNombre(Long id, String nuevoNombre) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franquicia.setNombre(nuevoNombre);
        return toDto(franquiciaRepository.save(franquicia));
    }

    private FranquiciaDTO toDto(Franquicia franquicia) {
        FranquiciaDTO dto = new FranquiciaDTO();
        dto.setId(franquicia.getId());
        dto.setNombre(franquicia.getNombre());
        return dto;
    }
}
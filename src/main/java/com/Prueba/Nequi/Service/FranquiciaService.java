package com.Prueba.Nequi.Service;


import com.Prueba.Nequi.Dto.CrearFranquiciaRequest;
import com.Prueba.Nequi.Dto.FranquiciaDTO;

import java.util.List;

public interface FranquiciaService {
    FranquiciaDTO crearFranquicia(CrearFranquiciaRequest request);
    List<FranquiciaDTO> listarFranquicias();
    FranquiciaDTO actualizarNombre(Long id, String nuevoNombre);
}
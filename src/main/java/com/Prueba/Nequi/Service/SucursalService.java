package com.Prueba.Nequi.Service;

import com.Prueba.Nequi.Dto.CrearSucursalRequest;
import com.Prueba.Nequi.Dto.SucursalDTO;

public interface SucursalService {
    SucursalDTO agregarSucursal(CrearSucursalRequest request);
    SucursalDTO actualizarNombre(Long id, String nuevoNombre);
}

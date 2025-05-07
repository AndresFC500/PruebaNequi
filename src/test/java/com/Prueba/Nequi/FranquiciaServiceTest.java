package com.Prueba.Nequi;

import com.Prueba.Nequi.Dto.CrearFranquiciaRequest;
import com.Prueba.Nequi.Dto.FranquiciaDTO;
import com.Prueba.Nequi.Model.Franquicia;
import com.Prueba.Nequi.Repository.FranquiciaRepository;
import com.Prueba.Nequi.Service.impl.FranquiciaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FranquiciaServiceTest {

    @Mock
    private FranquiciaRepository franquiciaRepository;

    @InjectMocks
    private FranquiciaServiceImpl franquiciaService;

    @Test
    void testCrearFranquicia() {
        CrearFranquiciaRequest request = new CrearFranquiciaRequest();
        request.setNombre("Franquicia de prueba");

        Franquicia franquicia = Franquicia.builder()
                .nombre(request.getNombre())
                .build();

        when(franquiciaRepository.save(any(Franquicia.class))).thenReturn(franquicia);

        FranquiciaDTO franquiciaDTO = franquiciaService.crearFranquicia(request);

        assertNotNull(franquiciaDTO);
        assertEquals("Franquicia de prueba", franquiciaDTO.getNombre());
        verify(franquiciaRepository).save(any(Franquicia.class));
    }

    @Test
    void testListarFranquicias() {
        Franquicia franquicia1 = Franquicia.builder().nombre("Franquicia 1").build();
        Franquicia franquicia2 = Franquicia.builder().nombre("Franquicia 2").build();
        when(franquiciaRepository.findAll()).thenReturn(List.of(franquicia1, franquicia2));

        List<FranquiciaDTO> franquiciasDTO = franquiciaService.listarFranquicias();

        assertNotNull(franquiciasDTO);
        assertEquals(2, franquiciasDTO.size());
        assertEquals("Franquicia 1", franquiciasDTO.get(0).getNombre());
        assertEquals("Franquicia 2", franquiciasDTO.get(1).getNombre());
    }

    @Test
    void testActualizarNombre() {
        Long id = 1L;
        String nuevoNombre = "Nuevo nombre de franquicia";

        Franquicia franquicia = Franquicia.builder()
                .id(id)
                .nombre("Nombre anterior")
                .build();

        when(franquiciaRepository.findById(id)).thenReturn(Optional.of(franquicia));
        when(franquiciaRepository.save(any(Franquicia.class))).thenReturn(franquicia);

        FranquiciaDTO franquiciaDTO = franquiciaService.actualizarNombre(id, nuevoNombre);

        assertNotNull(franquiciaDTO);
        assertEquals(nuevoNombre, franquiciaDTO.getNombre());
        verify(franquiciaRepository).save(any(Franquicia.class));
    }

    @Test
    void testActualizarNombre_FranquiciaNoExistente() {
        Long id = 1L;
        String nuevoNombre = "Nuevo nombre de franquicia";

        when(franquiciaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            franquiciaService.actualizarNombre(id, nuevoNombre);
        });
    }
}

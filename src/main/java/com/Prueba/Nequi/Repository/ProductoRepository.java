package com.Prueba.Nequi.Repository;

import com.Prueba.Nequi.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
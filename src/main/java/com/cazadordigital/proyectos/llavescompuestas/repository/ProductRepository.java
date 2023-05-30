package com.cazadordigital.proyectos.llavescompuestas.repository;

import com.cazadordigital.proyectos.llavescompuestas.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

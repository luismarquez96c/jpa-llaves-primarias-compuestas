package com.cazadordigital.proyectos.llavescompuestas.repository;

import com.cazadordigital.proyectos.llavescompuestas.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

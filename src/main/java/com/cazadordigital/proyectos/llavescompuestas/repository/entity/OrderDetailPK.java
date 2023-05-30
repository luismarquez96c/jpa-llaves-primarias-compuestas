package com.cazadordigital.proyectos.llavescompuestas.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
public class OrderDetailPK {

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "productId")
    private long productId;

}

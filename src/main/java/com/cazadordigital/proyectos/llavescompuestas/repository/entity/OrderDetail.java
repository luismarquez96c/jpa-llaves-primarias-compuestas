package com.cazadordigital.proyectos.llavescompuestas.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    @EmbeddedId
    private OrderDetailPK id;

    private int quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @MapsId("orderId")
    @ToString.Exclude
    private Order order;

    public BigDecimal getSubtotal(){
        if(unitPrice == null) return BigDecimal.ZERO;
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

}

package com.cazadordigital.proyectos.llavescompuestas.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "\"order\"")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "creation_date", insertable = true, updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderDetail> details;

    public static enum OrderStatus{
        PENDING, IN_PROCESS, COMPLETED, CANCELLED;
    }

    public BigDecimal getTotal(){
        if(details == null || details.isEmpty()) return BigDecimal.ZERO;

        return details.stream().map( detail -> detail.getSubtotal() )
                .reduce(BigDecimal.ZERO, (current, total) -> total.add(current) );
    }
}

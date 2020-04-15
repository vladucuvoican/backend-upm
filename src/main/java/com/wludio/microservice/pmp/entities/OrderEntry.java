package com.wludio.microservice.pmp.entities;

import com.wludio.microservice.pmp.entities.enums.Unit;
import lombok.Data;

import javax.persistence.*;

import static com.wludio.microservice.pmp.entities.constants.Schema.PLATFORM_MANAGEMENT;

@Data
@Entity
@Table(name="order_entry", schema = PLATFORM_MANAGEMENT)
public class OrderEntry extends BaseEntity {

    @Column(name="price_per_unit")
    private Double pricePerUnit;

    @Column(name="quantity")
    private Long quantity;

    @Column(name="currency")
    private String currency;

    @JoinColumn(name = "PRODUCT_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name="unit")
    private Unit unit;

}

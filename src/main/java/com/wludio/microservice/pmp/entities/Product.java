package com.wludio.microservice.pmp.entities;

import com.wludio.microservice.pmp.entities.enums.ProductState;
import com.wludio.microservice.pmp.entities.enums.Unit;
import lombok.Data;

import javax.persistence.*;

import static com.wludio.microservice.pmp.entities.constants.Schema.PLATFORM_MANAGEMENT;

@Data
@Entity
@Table(name="product", schema = PLATFORM_MANAGEMENT)
public class Product extends BaseEntity {

    @Column(name="title")
    private String title;

    @Column(name="image")
    private String image;

    @Column(name="price_per_unit")
    private Double pricePerUnit;

    @Column(name="quantity")
    private Long quantity;

    @Column(name="currency")
    private String currency;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="unit")
    private Unit unit;

    @Enumerated(EnumType.STRING)
    @Column(name="state")
    private ProductState state;
}



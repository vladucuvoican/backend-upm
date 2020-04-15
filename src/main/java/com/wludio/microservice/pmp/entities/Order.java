package com.wludio.microservice.pmp.entities;

import com.wludio.microservice.pmp.entities.enums.OrderState;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.wludio.microservice.pmp.entities.constants.Schema.PLATFORM_MANAGEMENT;

@Data
@Entity
@Table(name="order", schema = PLATFORM_MANAGEMENT)
public class Order extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Column(name="purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name="total_price")
    private Double totalPrice;

    @Column(name="currency")
    private String currency;

    @BatchSize(size = 100)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderEntry> orderEntries = new ArrayList<>(1);

    @Enumerated(EnumType.STRING)
    @Column(name="state")
    private OrderState state;

    @Column(name="note")
    private String note;
}




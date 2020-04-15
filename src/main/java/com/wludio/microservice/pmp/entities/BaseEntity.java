package com.wludio.microservice.pmp.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    private Long id;

    @Builder.Default
    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;
}

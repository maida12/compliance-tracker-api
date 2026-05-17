package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplianceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certificateType;

    private LocalDate expiryDate;

    private Boolean approved;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
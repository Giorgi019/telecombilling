package com.giorgi.telecombilling.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "invoices", uniqueConstraints = @UniqueConstraint(columnNames = {"subscriber_id", "month"}))
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    @Column(nullable = false)
    private String month;

    private int usedMinutes;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    private boolean paid;


}

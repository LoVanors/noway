package com.example.noway.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TRAVEL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DESTINATION")
    private String destination;
    @Column(name = "END_DATE")
    private LocalDate endDate;
    @Column(name = "START_DATE")
    private LocalDate startDate;
    @Column(name = "PRICE")
    private BigDecimal price;

    public Travel(String destination, String description, LocalDate endDate, LocalDate startDate, BigDecimal price){
        this.description=description;
        this.destination=destination;
        this.endDate=endDate;
        this.startDate=startDate;
        this.price=price;
    }
}

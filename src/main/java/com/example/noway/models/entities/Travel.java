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
    private Double price;
    @Column(name = "image")
    private String image;

    public Travel(String destination, String description, LocalDate startDate, LocalDate endDate,  Double price, String image){
        this.description=description;
        this.destination=destination;
        this.endDate=endDate;
        this.startDate=startDate;
        this.price=price;
        this.image=image;
    }
    public Travel(String destination, String description, LocalDate startDate, LocalDate endDate,  Double price){
        this.description=description;
        this.destination=destination;
        this.endDate=endDate;
        this.startDate=startDate;
        this.price=price;
        this.image="aucun image disponible";
    }


}

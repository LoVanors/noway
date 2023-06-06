package com.example.noway.models.forms;

import com.example.noway.models.entities.Customer;
import com.example.noway.models.entities.Travel;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravelAddForm {
    private String description;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
    private String image;

    public Travel toEntity(){
        return Travel.builder()
                .description(getDescription())
                .destination(getDestination())
                .startDate(getStartDate())
                .endDate(getEndDate())
                .price(getPrice())
                .image(getImage())
                .build();
    }
}

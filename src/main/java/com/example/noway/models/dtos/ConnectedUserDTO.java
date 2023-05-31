package com.example.noway.models.dtos;

import com.example.noway.models.entities.Customer;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ConnectedUserDTO {
    private Long id;
    private String username;

    public static ConnectedUserDTO fromEntity(Customer customer){
        return ConnectedUserDTO.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .build();
    }
}

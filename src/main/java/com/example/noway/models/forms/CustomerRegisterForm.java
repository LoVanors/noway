package com.example.noway.models.forms;

import com.example.noway.models.entities.Customer;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterForm {

    private String username;
    private String email;
    private String password;

    public Customer toEntity(){
        return Customer.builder()
                .username(getUsername())
                .email(getEmail())
                .password(getPassword())
                .build();
    }
}

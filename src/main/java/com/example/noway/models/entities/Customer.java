package com.example.noway.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER",uniqueConstraints = {@UniqueConstraint(name = "UK_USER__USERNAME__EMAIL",columnNames = {"USERNAME","EMAIL"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="USERNAME", length = 40)
    private String username;
    @Column(name = "EMAIL", length = 50)
    private String email;
    @Column(name = "PASSWORD")
    private String password;

    public Customer(String username,String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public Customer(String username, String password) {
        this.username=username;
        this.password=password;
    }
}

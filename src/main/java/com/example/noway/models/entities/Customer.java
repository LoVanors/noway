package com.example.noway.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.xml.transform.Source;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = {@UniqueConstraint(name = "UK_USER__USERNAME__EMAIL", columnNames = {"USERNAME", "EMAIL"})})
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
    @NotBlank(message = "nom d'utilisateur invalide")
    @Column(name = "USERNAME", length = 40)
    private String username;
    @Email(message = "Adresse email non valide")
    @Column(name = "EMAIL", length = 50)
    private String email;
    @NotBlank(message = "mot de passe invalide")
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "isAdmin")
    private Boolean isAdmin;

    public Customer(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = false;
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;
    }

}

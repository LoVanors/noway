package com.example.noway.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "ADMIN",uniqueConstraints = {@UniqueConstraint(name = "UK_ADMIN__USERNAME",columnNames = {"USERNAME"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    public Admin(String username){
        this.username=username;
    }
}

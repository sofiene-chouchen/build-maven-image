package com.poly.gestioncatalogueg1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pour faire l auto increment
    private Long id;
    private String nom;
    private double prix;
    private int quantite;

    @ManyToOne
    private Categorie categorie;
}

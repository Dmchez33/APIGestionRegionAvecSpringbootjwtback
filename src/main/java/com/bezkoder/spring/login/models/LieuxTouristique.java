package com.bezkoder.spring.login.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lieuxtourique")
@Getter
@Setter
@NoArgsConstructor
public class LieuxTouristique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @Lob
    private String description;
    private String image;

    //@ManyToOne
    //JOINTURE ENTRE LA TABLE HABITANT et region
    @ManyToOne
    @JoinColumn(name = "idRegion_id")
    private Region idRegion;
}

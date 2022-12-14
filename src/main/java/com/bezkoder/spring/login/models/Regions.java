package com.bezkoder.spring.login.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "regions")
@Getter
@Setter
@NoArgsConstructor
public class Regions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;

    private String code_region;

    private String domaine_activite;

    private String superficie;

    private String langue_majoritaire;

    @Column(unique = true, length = 50)
    private String nom_region;

    //JOINTURE ENTRE LA TABLE REGION ET PAYS
    @ManyToOne
    @JoinColumn(name = "idpays_id")
    private Pays idpays;

}

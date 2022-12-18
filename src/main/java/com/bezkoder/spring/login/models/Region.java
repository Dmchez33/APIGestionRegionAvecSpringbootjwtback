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
public class Region {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
        private Long id;

        private String coderegion;

        private String domaineactivite;

        private String superficie;

        private String languemajoritaire;

        @Lob
        private String description;
        private String image;

        @Column(unique = true, length = 50)
        private String nomregion;

        //JOINTURE ENTRE LA TABLE REGION ET PAYS
        @ManyToOne
        @JoinColumn(name = "idpays_id")
        private Pays idpays;


}

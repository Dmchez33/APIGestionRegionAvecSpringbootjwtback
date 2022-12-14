package com.bezkoder.spring.login.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "habitants")
@Getter
@Setter
@NoArgsConstructor
public class Habitant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nbre_habitant;

    //@ManyToOne
    //JOINTURE ENTRE LA TABLE HABITANT et region
    @ManyToOne
    @JoinColumn(name = "idRegion_id")
    private Regions idRegion;

    //JOINTURE ENTRE LA TABLE HABITANT ET LA TABLE
    @ManyToOne
    @JoinColumn(name = "id_avoirhabitant_id")
    private AvoirHabitant id_avoirhabitant;
}

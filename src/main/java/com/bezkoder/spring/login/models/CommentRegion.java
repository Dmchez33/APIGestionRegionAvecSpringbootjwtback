package com.bezkoder.spring.login.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "commentaire")
@Getter
@Setter
@NoArgsConstructor
public class CommentRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    //@ManyToOne
    //JOINTURE ENTRE LA TABLE commentaire et region
    @ManyToOne
    @JoinColumn(name = "idRegion_id")
    private Region idRegion;

    //@ManyToOne
    //JOINTURE ENTRE LA TABLE commentaire et user
    @ManyToOne
    @JoinColumn(name = "idUser_id")
    private User idUser;

}

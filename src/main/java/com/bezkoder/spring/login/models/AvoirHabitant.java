package com.bezkoder.spring.login.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "avoirhabitant")
@Getter
@Setter
@NoArgsConstructor
public class AvoirHabitant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long annee;

}

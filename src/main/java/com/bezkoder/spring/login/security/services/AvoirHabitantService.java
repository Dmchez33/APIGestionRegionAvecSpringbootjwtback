package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.AvoirHabitant;

import java.util.List;

public interface AvoirHabitantService {
    //DECLARATION DE LA METHODE CREER
    AvoirHabitant creer(AvoirHabitant avoirhabitant);

    //DECLARATION DE LA METHODE LIRE
    List<AvoirHabitant> lire();

    //DECLARATION DE LA METHODE MODIFIER
    AvoirHabitant modifier(Long id, AvoirHabitant avoirhabitant);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);
}

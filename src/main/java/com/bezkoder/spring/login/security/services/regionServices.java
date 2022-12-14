package com.bezkoder.spring.login.security.services;



import com.bezkoder.spring.login.models.Regions;

import java.util.List;

public interface regionServices {
    //methode ajouter Regions en indiquant les le pays et l'habitant
    //List<Object[]> CrePays(Regions regions, Pays pays, Habitant habitant, AvoirHabitant avoirHabitant);
    //methode permettant de creer une region
    Regions creer(Regions regions);
    //methode permettant de lister une region
    List<Object[]> lire();
    //methode permettant de lister des regions sans pays
    List<Object[]> lireSansPays();
    //methode permettant de lister des regions avec l'évolution
    List<Object[]> lireRegionHbtAnnee();
    //methode permettant de lister les regions d'un pays
    List<Object[]> lireRegionOfPays(String pays);
    //methode permettant de modifier une region
    Regions modifier(Long id, Regions regions);
    //methode permettant de de supprimer une region
    String supprimer(Long id);
}

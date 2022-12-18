package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Habitant;
import com.bezkoder.spring.login.models.LieuxTouristique;

import java.util.List;

public interface LieuxTouristiqueService {

    //CREATION DE LIEUX TOURISTIQUES
    LieuxTouristique creer(LieuxTouristique lieuxTouristique);

    //LISTER LIEUX TOURISTIQUE
    List<LieuxTouristique> lire();

    //MODIFIER LIEUX TOURISTIQUES
    LieuxTouristique modifier(Long id, LieuxTouristique lieuxTouristique);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);
}

package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.CommentRegion;
import com.bezkoder.spring.login.models.LieuxTouristique;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentRegionService {
    //CREATION DE LIEUX TOURISTIQUES
    CommentRegion creer(CommentRegion commentRegion);

    //LISTER LIEUX TOURISTIQUE
    List<CommentRegion> lire();

    //MODIFIER LIEUX TOURISTIQUES
    CommentRegion modifier(Long id, CommentRegion commentRegion);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);
}

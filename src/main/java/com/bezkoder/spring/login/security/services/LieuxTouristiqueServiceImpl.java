package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Habitant;
import com.bezkoder.spring.login.models.LieuxTouristique;
import com.bezkoder.spring.login.repository.LieuxTouristiquesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs
@Service
public class LieuxTouristiqueServiceImpl implements LieuxTouristiqueService {

    private LieuxTouristiquesRepository lieuxTouristiquesRepository;

    @Override
    public LieuxTouristique creer(LieuxTouristique lieuxTouristique) {
        return lieuxTouristiquesRepository.save(lieuxTouristique);
    }

    @Override
    public List<LieuxTouristique> lire() {
        return lieuxTouristiquesRepository.findAll();
    }

    @Override
    public LieuxTouristique modifier(Long id, LieuxTouristique lieuxTouristique) {
        return lieuxTouristiquesRepository.findById(id).map(
                lieuxTouristique1 -> {
                    lieuxTouristique1.setNom(lieuxTouristique.getNom());
                    lieuxTouristique1.setDescription(lieuxTouristique.getDescription());
                    lieuxTouristique1.setImage(lieuxTouristique.getImage());
                    lieuxTouristique1.setIdRegion(lieuxTouristique.getIdRegion());
                    return lieuxTouristiquesRepository.save(lieuxTouristique1);
                }
        ).orElseThrow(() -> new RuntimeException("LieuxTouristique non trouver"));
    }

    @Override
    public String supprimer(Long id) {
        if (lieuxTouristiquesRepository.findById(id) != null)
        {   lieuxTouristiquesRepository.deleteById(id);
            return "LIEUX TOURISTIQUES SUPPRIMER AVEC SUCCES";
        }
        else {
            return "LIEUX TOURISTIQUES NON SUPPRIMER";
        }
    }
}

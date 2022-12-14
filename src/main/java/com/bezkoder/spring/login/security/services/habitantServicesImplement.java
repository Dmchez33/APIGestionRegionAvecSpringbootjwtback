package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.Habitant;
import com.bezkoder.spring.login.repository.habitantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class habitantServicesImplement implements habitantServices{

    //DECLARATION D'UN ATTRIBUT DE TYPE REPOSITORY
    private habitantRepository habitantrepository;

    //IMPLEMENTATION DE LA METHODE CREER
    @Override
    public Habitant creer(Habitant habitant) {
        return habitantrepository.save(habitant);
    }

    //IMPLEMENTATION DE LA METHODE LIRE
    @Override
    public List<Habitant> lire() {
        return habitantrepository.findAll();
    }

    //IMPLEMENTATION DE LA METHODE MODIFIER
    @Override
    public Habitant modifier(Long id, Habitant habitant) {
        return habitantrepository.findById(id)
                .map(r->{
                    r.setNbre_habitant(habitant.getNbre_habitant());
                    return habitantrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Habitant non trouver"));
    }

    //IMPLEMENTATION DE LA METHODE SUPPRIMER
    @Override
    public String supprimer(Long id) {
        habitantrepository.deleteById(id);
        return "Habitant Supprimer";
    }
}

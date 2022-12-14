package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.Pays;
import com.bezkoder.spring.login.repository.paysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs

@Service
public class paysSeImplement implements paysServices {

    //DECLARATION D'UN ATTRIBUT DE TYPE REPOSITORY'
    private paysRepository paysrepository;

    //IMPLEMENTATION DE LA METHODE CREER
    @Override
    public Pays creer(Pays pays) {
         return paysrepository.save(pays);
    }

    //IMPLEMENTATION DE LA METHODE LIRE
    @Override
    public List<Pays> lire() {
        return paysrepository.findAll();
    }

    //IMPLEMENTATION DE LA METHODE MODIFIER
    @Override
    public Pays modifier(Long id, Pays pays) {
        return paysrepository.findById(id)
                .map(r->{
                    r.setNom(pays.getNom());
                    return paysrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Pays nom trouver"));
    }

    //IMPLEMENTATION DE LA METHODE SUPPRIMER
    @Override
    public String supprimer(Long id) {
        paysrepository.deleteById(id);
        return "Pays Supprimer";
    }
}

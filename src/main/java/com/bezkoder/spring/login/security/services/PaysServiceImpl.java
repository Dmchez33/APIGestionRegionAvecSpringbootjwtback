package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Pays;
import com.bezkoder.spring.login.repository.PaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs
@Service
public class PaysServiceImpl implements PaysService {
    //DECLARATION D'UN ATTRIBUT DE TYPE REPOSITORY'
    private PaysRepository paysrepository;

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
                    r.setImage(pays.getImage());
                    r.setDescription(pays.getDescription());
                    r.setDensite(pays.getDensite());
                    r.setSuperficie(pays.getSuperficie());
                    return paysrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Pays nom trouver"));
    }

    //IMPLEMENTATION DE LA METHODE SUPPRIMER
    @Override
    public String supprimer(Long id) {
        paysrepository.deleteById(id);
        return "Pays Supprimer";
    }

    @Override
    public Pays trouverPaysParId(String nompays) {
        return paysrepository.findByNom(nompays) ;
    }
}

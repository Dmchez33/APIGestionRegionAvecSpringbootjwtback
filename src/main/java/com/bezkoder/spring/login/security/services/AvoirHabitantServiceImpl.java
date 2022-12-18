package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.AvoirHabitant;
import com.bezkoder.spring.login.repository.AvoirHabitantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs
@Service
public class AvoirHabitantServiceImpl implements AvoirHabitantService {

    //DECLARATION D'UNE VARIABLE DE TYPE REPOSITORY
    private AvoirHabitantRepository avoirhabitantrepository;

    //IMPLEMENTATION DE LA METHODE CREER
    @Override
    public AvoirHabitant creer(AvoirHabitant avoirhabitant) {
        return avoirhabitantrepository.save(avoirhabitant);
    }

    //IMPLEMENTATION DE LA METHODE LIRE
    @Override
    public List<AvoirHabitant> lire() {
        return avoirhabitantrepository.findAll();
    }

    //IMPLEMENTATION DE LA METHODE MODIFIER
    @Override
    public AvoirHabitant modifier(Long id, AvoirHabitant avoirhabitant) {
        return avoirhabitantrepository.findById(id)
                .map(ah->{
                    ah.setAnnee(avoirhabitant.getAnnee());
                    return avoirhabitantrepository.save(ah);
                }).orElseThrow(() -> new RuntimeException("Habitant non trouver"));
    }

    //IMPLEMENTATION DE LA METHODE SUPPRIMER
    @Override
    public String supprimer(Long id) {
        avoirhabitantrepository.deleteById(id);
        return "Habitant Supprimer";
    }
}

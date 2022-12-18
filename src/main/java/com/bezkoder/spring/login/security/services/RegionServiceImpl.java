package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Region;
import com.bezkoder.spring.login.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs
@Service
public class RegionServiceImpl implements RegionService {

    private  final RegionRepository regionsrepository;

    @Override
    public Region creer(Region regions) {
        return regionsrepository.save(regions);
    }

    @Override
    public List<Object[]> lire() {
        return regionsrepository.FINDALLREGION();
    }

    @Override
    public List<Region> lire1() {
        return regionsrepository.findAll();
    }

    @Override
    public List<Object[]> lireRegionHbtAnnee() {
        return  regionsrepository.FINDREGION_HBT_ANNEE();
    }

    @Override
    public List<Object[]> lireRegionOfPays(String pays) {
        return  regionsrepository.FINDREGIONSOFPAYS(pays);
    }

    @Override
    public List<Object[]> lireSansPays(){return regionsrepository.FINDALLREGIONWITHOUTPAYS();}
    @Override
    public Region modifier(Long id, Region regions) {
        return regionsrepository.findById(id)
                .map(r-> {
                    r.setCoderegion(regions.getCoderegion());
                    r.setDomaineactivite(regions.getDomaineactivite());
                    r.setDomaineactivite(regions.getDomaineactivite());
                    r.setLanguemajoritaire(regions.getLanguemajoritaire());
                    r.setSuperficie(regions.getSuperficie());
                    return regionsrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Region non trouvé !"));
    }

    @Override
    public String supprimer(Long id) {
        regionsrepository.deleteById(id);
        return "Region supprimé";
    }
}

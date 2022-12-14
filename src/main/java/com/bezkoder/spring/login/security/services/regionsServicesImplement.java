package com.bezkoder.spring.login.security.services;


import com.bezkoder.spring.login.models.Regions;
import com.bezkoder.spring.login.repository.regionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class regionsServicesImplement implements regionServices{

    private  final regionsRepository regionsrepository;

    @Override
    public Regions creer(Regions regions) {
        return regionsrepository.save(regions);
    }

    @Override
    public List<Object[]> lire() {
        return regionsrepository.FINDALLREGION();
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
    public Regions modifier(Long id, Regions regions) {
        return regionsrepository.findById(id)
                .map(r-> {
                    r.setCode_region(regions.getCode_region());
                    r.setDomaine_activite(regions.getDomaine_activite());
                    r.setDomaine_activite(regions.getDomaine_activite());
                    r.setLangue_majoritaire(regions.getLangue_majoritaire());
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
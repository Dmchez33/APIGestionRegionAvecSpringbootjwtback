package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.AvoirHabitant;
import com.bezkoder.spring.login.security.services.AvoirHabitantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apu/annee")
@AllArgsConstructor
@Api(value = "annee", description = "MANIPULATION DES DONNEES DE LA TABLE AVOIRHABITANT")
public class AvoirHabitantController {
    @Autowired
    final private AvoirHabitantService avoirhabitantService;

    @ApiOperation(value = "AJOUT DES DONNEE DANS LA TABLE AVOIRHABITANT ")
    @PostMapping("/ajout_annee")
    public AvoirHabitant creer(@RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.creer(avoirhabitant);
    }

    @ApiOperation(value = "LISTE ANNEE")
    @GetMapping("/liste_annee")
    public List<AvoirHabitant> lister(){
        return avoirhabitantService.lire();
    }

    @ApiOperation(value = "MODIFIER LES DONNER DE LA TABLE AVOIRHABITANT")
    @PutMapping("/modifier_annee/{indique_identifiant_annee_à_modifier}")
    public AvoirHabitant modifier(@PathVariable Long indique_identifiant_annee_à_modifier, @RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.modifier(indique_identifiant_annee_à_modifier, avoirhabitant);
    }

    @ApiOperation(value = "SUPPRIMER LES DONNEES DE LA TABLE AVOIRHABITANT")
    @DeleteMapping("/supprimer_annee/{indique_identifiant_annee_à_supprimer}")
    public String supprimer(@PathVariable Long indique_identifiant_annee_à_supprimer){
        return avoirhabitantService.supprimer(indique_identifiant_annee_à_supprimer);
    }
}

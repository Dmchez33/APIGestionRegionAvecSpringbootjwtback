package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Habitant;
import com.bezkoder.spring.login.security.services.HabitantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitant")
@AllArgsConstructor
@Api(value = "habitant", description = "MANIPULATION DES DONNEES DE LA TABLE PAYS")
public class HabitantController {

    @Autowired
    final private HabitantService habitantservice;

    @ApiOperation(value = "AJOUT DES DONNEE DANS LA TABLE HABITANT")
    @PostMapping("/ajout_habitant")
    public void creer(@RequestBody Habitant habitant){
        habitantservice.creer(habitant);
    }

    @ApiOperation(value = "LISTE HABITANT")
    @GetMapping("/liste_habitant")
    public List<Habitant> lister(){
        return habitantservice.lire();
    }

    @ApiOperation(value = "MODIFIER DES DONNEES DE LA TABLE HABITANT")
    @PutMapping("/modifier_habitant/{indique_identifiant_habitant_à_modifier}")
    public Habitant modifier(@PathVariable Long indique_identifiant_habitant_à_modifier, @RequestBody Habitant habitant){
        return habitantservice.modifier(indique_identifiant_habitant_à_modifier, habitant);
    }

    @ApiOperation(value = "SUPPRESSION DES DONNEES DE LA TABLE HABITANT")
    @DeleteMapping("/supprimer_habitant/{indique_identifiant_habitant_à_supprimer}")
    public String supprimer(@PathVariable Long indique_identifiant_habitant_à_supprimer){
        return habitantservice.supprimer(indique_identifiant_habitant_à_supprimer);
    }

}


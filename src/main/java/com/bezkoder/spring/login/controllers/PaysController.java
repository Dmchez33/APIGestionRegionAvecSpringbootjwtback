package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Pays;
import com.bezkoder.spring.login.security.services.paysServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pays")
@RestController
@Api(value = "pays", description = "MANIPULATION DES DONNEES DE LA TABLE PAYS")
public class PaysController {

    @Autowired
    paysServices paysservice;

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE PAYS")
    @PostMapping("/ajout_pays")
    public Pays create(@RequestBody Pays pays){
        return paysservice.creer(pays);
    }

    @ApiOperation(value = "LISTE PAYS")
    @GetMapping("/liste_pays")
    public List<Pays> read(){
        return paysservice.lire();
    }

    @ApiOperation(value = "MODIFICATION DES DONNEES DE LA TABLE PAYS")
    @PutMapping("/modifier_pays/{indique_identifiant_Pays_à_modifier}")
    public Pays update(@PathVariable Long indique_identifiant_Pays_à_modifier, @RequestBody Pays pays){
        return paysservice.modifier(indique_identifiant_Pays_à_modifier, pays);
    }

    @ApiOperation(value = "SUPPRESION DES DONNEE DANS LA TABLE PAYS")
    @DeleteMapping("/supprimer_pays/{indique_identifiant_Pays_à_modifier}")
    public String delete(@PathVariable Long indique_identifiant_Pays_à_modifier){
        return paysservice.supprimer(indique_identifiant_Pays_à_modifier);
    }
}

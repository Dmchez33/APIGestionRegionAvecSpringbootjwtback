package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.configuration.SaveImage;
import com.bezkoder.spring.login.models.Pays;
import com.bezkoder.spring.login.models.Region;
import com.bezkoder.spring.login.security.services.PaysService;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/pays")
@RestController
@Api(value = "pays", description = "MANIPULATION DES DONNEES DE LA TABLE PAYS")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class PaysController {

    @Autowired
    PaysService paysservice;

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE PAYS")
    @PostMapping("/ajout_pays")
    @PreAuthorize("hasRole('ADMIN')")
    public Object create(@RequestParam(value = "pays") String pay,
                         @RequestParam(value = "file", required = true) MultipartFile file) {
        try {
            Pays pays = new JsonMapper().readValue(pay, Pays.class);
            if (file != null) {
                System.out.println("ggggg");
                pays.setImage(SaveImage.save("activite", file, pays.getNom()));
            }
            return paysservice.creer(pays);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @ApiOperation(value = "LISTE PAYS")
    @GetMapping("/liste_pays")
    public List<Pays> read() {
        return paysservice.lire();
    }

    @ApiOperation(value = "LISTE PAYS")
    @GetMapping("/liste_pays/{nompays}")
    public Pays readPaysparNom(@PathVariable String nom) {
        return paysservice.trouverPaysParId(nom);
    }

    @ApiOperation(value = "MODIFICATION DES DONNEES DE LA TABLE PAYS")
    @PutMapping("/modifier_pays/{id}")
    public Object update(@PathVariable Long id,
                         @RequestParam(value = "pays") String pay,
                         @RequestParam(value = "file", required = true) MultipartFile file
    ) {
        try {
            Pays pays = new JsonMapper().readValue(pay, Pays.class);
            if (file != null) {
                System.out.println("ggggg");
                pays.setImage(SaveImage.save("activite", file, pays.getNom()));
            }
            return paysservice.modifier(id, pays);

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ApiOperation(value = "SUPPRESION DES DONNEE DANS LA TABLE PAYS")
    @DeleteMapping("/supprimer_pays/{id}")
    public String delete(@PathVariable Long id) {
        return paysservice.supprimer(id);
    }
}

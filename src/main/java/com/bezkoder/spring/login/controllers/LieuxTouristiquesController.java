package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.configuration.SaveImage;
import com.bezkoder.spring.login.models.LieuxTouristique;
import com.bezkoder.spring.login.models.Pays;
import com.bezkoder.spring.login.models.Region;
import com.bezkoder.spring.login.repository.LieuxTouristiquesRepository;
import com.bezkoder.spring.login.repository.RegionRepository;
import com.bezkoder.spring.login.security.services.LieuxTouristiqueService;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/lieux")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class LieuxTouristiquesController {

    @Autowired
    final private LieuxTouristiqueService lieuxTouristiqueService;

    final private RegionRepository regionRepository;

    final private LieuxTouristiquesRepository lieuxTouristiquesRepository;

    @PostMapping("/ajout_Lieux/{nomRegion}")
    public Object creer(
            @PathVariable("nomRegion") String nomRegion,
            @RequestParam(value = "lieux") String lieux,
            @RequestParam(value = "file", required = true) MultipartFile file) {
        try {
            LieuxTouristique lieuxTouristique = new JsonMapper().readValue(lieux, LieuxTouristique.class);
            if (file != null) {
                System.out.println("ggggg");
                lieuxTouristique.setImage(SaveImage.save("activite", file, lieuxTouristique.getNom()));
            }
            Region region = regionRepository.findByNom(nomRegion);
            System.err.println(region);

            if (region != null){
                System.out.println("region don't null");
                lieuxTouristique.setIdRegion(region);
            }
            return lieuxTouristiqueService.creer(lieuxTouristique);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/modifierLieux/{id}")
    public Object modifier(
            @PathVariable Long id,
            @RequestParam(value = "lieux") String lieux,
            @RequestParam(value = "file", required = true) MultipartFile file) {
        try {
            LieuxTouristique lieuxTouristique = new JsonMapper().readValue(lieux, LieuxTouristique.class);
            if (file != null) {
                System.out.println("ggggg");
                lieuxTouristique.setImage(SaveImage.save("activite", file, lieuxTouristique.getNom()));
            }
            return lieuxTouristiqueService.modifier(id, lieuxTouristique);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/list_lieux")
    public List<LieuxTouristique> listerListe(){
        return lieuxTouristiqueService.lire();
    }

    @GetMapping("/list_lieuxbyNomRegion/{nom}")
    public List<LieuxTouristique> listerListeby(@PathVariable String nom){
        Region region = regionRepository.findByNom(nom);
        System.err.println("--------------------------------------");
        System.err.println(region);
        return lieuxTouristiquesRepository.findByIdRegion(region);
    }

    //METHODE PERMETTANT DE LISTER UN LIEUX PAR SON ID
    @GetMapping("/liste/{id}")
    public LieuxTouristique lister(@PathVariable Long id){
        System.err.println(this.lieuxTouristiquesRepository.findById(id).get());
        return this.lieuxTouristiquesRepository.findById(id).get();

    }





    @DeleteMapping("/supprimerLieux/{id}")
    public String delete(@PathVariable Long id) {
        return lieuxTouristiqueService.supprimer(id);
    }
}

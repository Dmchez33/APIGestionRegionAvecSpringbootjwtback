package com.bezkoder.spring.login.controllers;


/*
    @PostMapping gère les requêtes HTTP de type post
    @GetMapping gère les requêtes HTTP de type post
    @PutMapping gère les requêtes HTTP de type put
    @DeleteMapping gère les requêtes HTTP de type Delete
    @RequestBody mappe le corps HttpRequest à un objet de transfert
    @PathVariable //disposition des parametre
    un type List est garanti être un Iterable mais un type  Iterable peut ne pas être un List
*/

import com.bezkoder.spring.login.configuration.SaveImage;
import com.bezkoder.spring.login.models.CommentRegion;
import com.bezkoder.spring.login.models.Pays;
import com.bezkoder.spring.login.models.Region;
import com.bezkoder.spring.login.repository.CommentRegionRepository;
import com.bezkoder.spring.login.repository.PaysRepository;
import com.bezkoder.spring.login.repository.RegionRepository;
import com.bezkoder.spring.login.security.services.CommentRegionService;
import com.bezkoder.spring.login.security.services.HabitantService;
import com.bezkoder.spring.login.security.services.RegionService;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController//permet de specifier que la classe ci-dessus est un controlleur
@RequestMapping("/api/region")//l'url permettant d'appeler le controlleur de region
@AllArgsConstructor//Permet d'inclure le constructeur avec argument(lomboc)
@Api(value = "region", description = "MANIPULATION DES DONNEES DE LA TABLE REGION")
//permet de configurer une classe en tant que ressource Swagger
//le controlleur ci-dessous permet de manupiler la region
//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class RegionController {

    private final PaysRepository paysRepository;
    private final RegionRepository regionRepository;
    private final RegionService regionservice;//final permet rendre regionServices inchangeable
    private final HabitantService habitantservices;
    private final CommentRegionService commentRegionService;
    private final CommentRegionRepository commentRegionRepository;

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION")
    //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/ajout_region/{nomPays}")
    public Object create(
            @PathVariable("nomPays") String nomPays,
            @RequestParam(value = "region") String reg,
            @RequestParam(value = "file", required = true) MultipartFile file) {

        Pays pays = paysRepository.findByNom(nomPays);


        Region region = null;
        try {
            region = new JsonMapper().readValue(reg, Region.class);
            if (file != null) {
                System.out.println("ggggg");
                region.setImage(SaveImage.save("activite", file, region.getNom()));
            }

            if (pays != null){
                region.setIdpays(pays);
            }

            return regionservice.creer(region);
        } catch (Exception e) {

            return e.getMessage();
        }


    }

    @ApiOperation(value = "MODIFICATION DES DONNEES DE LA TABLE REGION")
    //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    @PutMapping("/modifier_region/{id}")
    public Object update(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "region") String reg,
            @RequestParam(value = "file", required = true) MultipartFile file) {

        Region region = null;
        try {
            region = new JsonMapper().readValue(reg, Region.class);
            if (file != null) {
                System.out.println("verfions si le selectionner n'est pas null");
                region.setImage(SaveImage.save("activite", file, region.getNom()));
            }
            return regionservice.modifier(id, region);
        } catch (Exception e) {
            return e.getMessage();
        }


    }

    /*
    * public Object create(@RequestBody Regions regions, Habitant habitant){
        try {
            regionservice.creer(regions);
            habitantservices.creer(habitant);
            return null;
        }catch (Exception e){
             return  ErorMessage.ErreurReponse("Région existe!", HttpStatus.OK,null);
        }


    }
    *
    * */

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION")
    //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    @GetMapping("/liste_region")
    public List<Region> read() {
        return regionservice.lire1();
    }

    @GetMapping("/liste_regionid/{nom}")
    public Region readById(@PathVariable("nom") String nom) {
        return regionRepository.findByNom(nom);
    }

    @ApiOperation(value = "LISTE DES REGIONS SANS PAYS")
    @GetMapping("/liste_region_sans_pays")
    public List<Object[]> list() {
        return regionservice.lireSansPays();
    }

    @ApiOperation(value = "LISTE DES REGIONS ET L'EVOLUTION DE SON NOMBRE HABITANT")
    @GetMapping("/liste_region_avec_habitant_annee")
    public List<Object[]> lireRegionHbtAnnee() {
        return regionservice.lireRegionHbtAnnee();
    }

    //liste des regions d'un pays donnée
    @ApiOperation(value = "LISTE DES REGIONS D'UN PAYS DONNEE")
    @GetMapping("/liste_region_pays/{pays}")
    public List<Object[]> lireRegionOfPays(@PathVariable String pays) {
        List<Object[]> list = regionservice.lireRegionOfPays(pays);

        return list;
    }

    //@ApiOperation(value = "MODIFICATION DES DONNEES DE LA TABLE REGION")
  /*  @PutMapping("/modifier_region/{identifiant_region}")
    public Region update(@PathVariable Long identifiant_region, @RequestBody Region regions) {
        return regionservice.modifier(identifiant_region, regions);
    }*/

    @ApiOperation(value = "SUPPRESION DES DONNEES DE LA TABLE REGION")
    @DeleteMapping("/supprimer_region/{identifiant_region}")
    public String delete(@PathVariable Long identifiant_region) {
        return regionservice.supprimer(identifiant_region);
    }

    //METHODE PERMETTANT DE COMMENTER UNE REGION
    @PostMapping("/comment")
    public CommentRegion addComment(@RequestBody CommentRegion commentRegion){
        return commentRegionService.creer(commentRegion);
    }

    //METHODE PERMETTANT DE COMMENTER UNE REGION
    @GetMapping("/lireComment")
    public List<CommentRegion> getComment(){
        return commentRegionService.lire();
    }

    @GetMapping("/lireCommentbyID/{idRegion}")
    public List<CommentRegion> getComment(@PathVariable("idRegion") String id){
        Region region = regionRepository.findByNom(id);
        return commentRegionRepository.findByIdRegion(region);
    }
}

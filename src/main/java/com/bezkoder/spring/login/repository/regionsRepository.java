package com.bezkoder.spring.login.repository;


import com.bezkoder.spring.login.models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface regionsRepository extends JpaRepository<Regions, Long> {

    /*
    * Definition des requetes native pour selection des region sans pays et avec pays
    *
    * */
    //@Query(value = "INSERT INTO Regions (code_region, nom_region, domaine_activite, superficie, langue_majoritaire, idpays, ")
    //Region sans pays
    @Query(value = "SELECT code_region,nom_region,domaine_activite,superficie,langue_majoritaire FROM regions", nativeQuery = true )
    public List<Object[]> FINDALLREGIONWITHOUTPAYS();

    //Region avec pays
    @Query(value = "SELECT regions.nom_region, pays.nom FROM regions, pays where regions.idpays_id = pays.id", nativeQuery = true )
    public List<Object[]> FINDALLREGION();

    //Une region donnée avec ses polpulation dans des differentes année
    @Query(value = "select habitants.nbre_habitant, regions.nom_region, avoirhabitant.annee from habitants, regions, avoirhabitant where habitants.id_region_id = regions.id and habitants.id_avoirhabitant_id = avoirhabitant.id;", nativeQuery = true )
    public List<Object[]> FINDREGION_HBT_ANNEE();

    //Trouvé les regions à partir d'un pays d'un pays donnée
    @Query(value = "select regions.nom_region from regions, pays where regions.idpays_id = pays.id and  pays.nom =:pays", nativeQuery = true )
    public List<Object[]> FINDREGIONSOFPAYS(@Param("pays") String pays);//@param fait reference parametre à afficher

}

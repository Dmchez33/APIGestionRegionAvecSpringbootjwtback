package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.LieuxTouristique;
import com.bezkoder.spring.login.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LieuxTouristiquesRepository extends JpaRepository<LieuxTouristique, Long> {

    LieuxTouristique findByNom(String nom);

    List<LieuxTouristique> findByIdRegion(Region region);
}

package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.LieuxTouristique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LieuxTouristiquesRepository extends JpaRepository<LieuxTouristique, Long> {

    LieuxTouristique findByNom(String nom);
}

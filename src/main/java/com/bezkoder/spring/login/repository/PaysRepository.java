package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysRepository extends JpaRepository<Pays, Long> {

    Pays findByNom( String nom);

}

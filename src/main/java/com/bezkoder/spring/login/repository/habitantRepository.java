package com.bezkoder.spring.login.repository;


import com.bezkoder.spring.login.models.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface habitantRepository extends JpaRepository<Habitant,Long> {
}

package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitantRepository extends JpaRepository<Habitant,Long> {
}

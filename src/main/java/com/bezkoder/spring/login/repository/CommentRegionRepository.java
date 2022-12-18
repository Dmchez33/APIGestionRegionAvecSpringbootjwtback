package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.CommentRegion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRegionRepository extends JpaRepository<CommentRegion, Long> {
}

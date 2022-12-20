package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.CommentRegion;
import com.bezkoder.spring.login.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRegionRepository extends JpaRepository<CommentRegion, Long> {

    List<CommentRegion> findByIdRegion(Region region);
}

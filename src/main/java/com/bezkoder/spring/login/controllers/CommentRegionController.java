package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.CommentRegion;
import com.bezkoder.spring.login.security.services.CommentRegionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commentRegion")
@AllArgsConstructor
public class CommentRegionController {
    @Autowired
    final private CommentRegionService commentRegionService;

    @PostMapping("/ajoutercomment")
    public CommentRegion commenter(@RequestBody CommentRegion commentRegion){
        return commentRegionService.creer(commentRegion);
    }

    @PostMapping("/modifiercomment/{id}")
    public CommentRegion modifier(@PathVariable Long id, @RequestBody CommentRegion commentRegion){
        return commentRegionService.modifier(id,commentRegion);
    }

    @DeleteMapping("/suprimer/{id}")
    public String suprimer(@PathVariable Long id){
        return this.commentRegionService.supprimer(id);
    }
}

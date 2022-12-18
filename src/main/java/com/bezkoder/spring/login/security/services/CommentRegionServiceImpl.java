package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.CommentRegion;
import com.bezkoder.spring.login.repository.CommentRegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs
@Service
public class CommentRegionServiceImpl implements CommentRegionService {

    private CommentRegionRepository commentRegionRepository;

    @Override
    public CommentRegion creer(CommentRegion commentRegion) {
        return commentRegionRepository.save(commentRegion);
    }

    @Override
    public List<CommentRegion> lire() {
        return commentRegionRepository.findAll();
    }

    @Override
    public CommentRegion modifier(Long id, CommentRegion commentRegion) {
        return commentRegionRepository.findById(id).map(
                commentRegion1 -> {
                    commentRegion1.setComment(commentRegion.getComment());
                    commentRegion1.setIdRegion(commentRegion.getIdRegion());
                    commentRegion1.setIdUser(commentRegion.getIdUser());
                    return commentRegionRepository.save(commentRegion1);
                }
        ).orElseThrow(() -> new RuntimeException("COMMENTAIRE REGION NON RETROUVER"));
    }

    @Override
    public String supprimer(Long id) {
        if (commentRegionRepository.findById(id) != null){
            commentRegionRepository.deleteById(id);
            return "COMMENTAIRE SUPPRIMER AVEC SUCCES";
        }
        return "COMMENTAIRE NON SUPPRIMER";
    }

}

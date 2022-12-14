package com.bezkoder.spring.login.security.services;



import com.bezkoder.spring.login.models.Pays;

import java.util.List;

public interface paysServices {
    Pays creer(Pays pays);
    List<Pays> lire();
    Pays modifier(Long id, Pays pays);
    String supprimer(Long id);
}

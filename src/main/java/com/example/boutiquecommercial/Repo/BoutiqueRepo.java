package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.Boutique;
import com.example.boutiquecommercial.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoutiqueRepo extends JpaRepository<Boutique, Long> {
    List<Boutique> findBoutiquesByCategorie(Categorie categorie) ;
}

package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.CentreCommercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcRepo extends JpaRepository <CentreCommercial, Long> {

}

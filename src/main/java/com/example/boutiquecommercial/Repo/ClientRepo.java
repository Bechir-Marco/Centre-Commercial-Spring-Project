package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.Client;
import com.example.boutiquecommercial.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Integer countClientByGenre (@Param("genre") Genre genre);
}

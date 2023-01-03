package com.example.boutiquecommercial.Entities;

import com.example.boutiquecommercial.Entities.Boutique;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CentreCommercial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    Long id ;
    String nom;
    String adresse;
    String login;
    String password;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "centreCommercial")
    List<Boutique> boutiques;

}

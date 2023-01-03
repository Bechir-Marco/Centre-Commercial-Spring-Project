package com.example.boutiquecommercial.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Boutique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
     Long id;
    String nom ;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    @ManyToMany(cascade = CascadeType.ALL )
    @JsonIgnore
    List<Client> clients;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    CentreCommercial centreCommercial;

}

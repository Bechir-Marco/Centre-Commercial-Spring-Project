package com.example.boutiquecommercial.Serv;

import com.example.boutiquecommercial.Entities.Boutique;
import com.example.boutiquecommercial.Entities.Categorie;
import com.example.boutiquecommercial.Entities.CentreCommercial;
import com.example.boutiquecommercial.Entities.Client;

import java.util.List;

public interface Serv {
     void ajouCentre(CentreCommercial centre);
     void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);
     void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
     List<Client> listeClients(Long idBoutique);
     List<Boutique> listeBoutiques(Long idCentre);
     List<Client> listeDeClientsParCategorie(Categorie categorie);
     void nbreClientParGenre();

}

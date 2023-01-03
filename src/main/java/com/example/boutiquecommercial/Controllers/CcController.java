package com.example.boutiquecommercial.Controllers;

import com.example.boutiquecommercial.Entities.Boutique;
import com.example.boutiquecommercial.Entities.Categorie;
import com.example.boutiquecommercial.Entities.CentreCommercial;
import com.example.boutiquecommercial.Entities.Client;
import com.example.boutiquecommercial.Serv.Serv;
import com.example.boutiquecommercial.Serv.ServImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Cc")
public class CcController  {
    private final Serv serv;

        @PostMapping("/addCenter")
        public void addCenter (@RequestBody CentreCommercial cc){
            serv.ajouCentre(cc);
        }

        @PostMapping("ajouterEtAffecter/{id-centre}")
        public void  ajouterEtAffecter (@RequestBody List<Boutique>lb,@PathVariable("id-centre") Long idCc) {
            serv.ajouterEtAffecterlisteBoutiques(lb,idCc);
        }
    @PostMapping("/ajouterEtAffecterClientBoutiques/{idBoutiques}")
    public void ajouterEtAffecterClientBoutiques(@RequestBody Client client, @PathVariable("idBoutiques")List<Long> idBoutiques) {
        serv.ajouterEtAffecterClientBoutiques(client,idBoutiques);
    }
    @GetMapping("ListClient/{idB}")
    public List<Client> listeClients(@PathVariable ("idB")Long idBoutique) {
         return    serv.listeClients(idBoutique);
    }
    @GetMapping("listeBoutiques/{idB}")
    public List<Boutique> listeBoutiques(Long idCentre) {
            return serv.listeBoutiques(idCentre);
    }
    @GetMapping("listeClients/{categorie}")
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {
            return serv.listeDeClientsParCategorie(categorie);
    }
}

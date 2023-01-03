package com.example.boutiquecommercial.Serv;

import com.example.boutiquecommercial.Entities.*;
import com.example.boutiquecommercial.Repo.BoutiqueRepo;
import com.example.boutiquecommercial.Repo.CcRepo;
import com.example.boutiquecommercial.Repo.ClientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServImp implements Serv {

    @Autowired
    BoutiqueRepo boutiqueRepo;
    @Autowired
    CcRepo ccRepo;
    @Autowired
    ClientRepo clientRepo;


    @Override
    public void ajouCentre(CentreCommercial centre) {
        for (Boutique boutique : centre.getBoutiques()) {
            boutique.setCentreCommercial(centre);
        }

        ccRepo.save(centre);
    }

    @Override
    @Transactional
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {

        CentreCommercial cc = ccRepo.findById(idCentre).orElse(null);
        for (Boutique b : lb
        ) {
            b.setCentreCommercial(cc);
        }
        boutiqueRepo.saveAll(lb);
    }

    @Override
    @Transactional
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {

        for (Long b : idBoutiques
        ) {
            Boutique boutique = boutiqueRepo.findById(b).orElse(null);
            boutique.getClients().add(client);
        }
        clientRepo.save(client);
    }

    @Override
    public List<Client> listeClients(Long idBoutique) {
       Boutique boutique = boutiqueRepo.findById(idBoutique).orElse(null);

        return (List<Client>) boutique.getClients();
    }

    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        CentreCommercial centreCommercial = ccRepo.findById(idCentre).orElse(null);
        return centreCommercial.getBoutiques();
    }

    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {
        List <Boutique> boutique =  boutiqueRepo.findBoutiquesByCategorie(categorie);
        for (Boutique b: boutique
             ) {
            return b.getClients();
        }
        return null;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void nbreClientParGenre() {
        log.info("--- Nombre des Clients MASCULIN :" + clientRepo.countClientByGenre(Genre.MASCULIN));
        log.info("--- Nombre des Clients FEMINs :" + clientRepo.countClientByGenre(Genre.FEMININ));
    }


}

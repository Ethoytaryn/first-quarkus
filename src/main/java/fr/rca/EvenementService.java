package fr.rca;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class EvenementService {

    @Inject
    EvenementRepository repository;

    @Transactional
    public List<Evenement> getEvenements() {

        List<EvenementEntity> list = new ArrayList<>();

        Iterable<EvenementEntity> resultat = repository.findAll();
        resultat.forEach(list::add);
        return list.stream().map(x -> new Evenement(x.getId(), x.getName(), x.getDebut(), x.getDuree())).collect(Collectors.toList());

    }

    @Transactional
    public Optional<Evenement> getEvenement(Long id) {

        Optional<EvenementEntity> resultat = repository.findById(id);

        return resultat.map(x -> new Evenement(x.getId(), x.getName(), x.getDebut(), x.getDuree()));

    }

    @Transactional
    public Optional<Evenement> add(NewEvenement newEvenement) {

        EvenementEntity entity = new EvenementEntity();
        entity.setName(newEvenement.getNom());
        entity.setDuree(newEvenement.getDuree());
        entity.setDebut(newEvenement.getDebut());

        EvenementEntity save =  repository.save(entity);

        return Optional.of(save).map(x -> new Evenement(x.getId(), x.getName(), x.getDebut(), x.getDuree()));

    }

    @Transactional
    public Long delete(Long id) {

        Optional<EvenementEntity> resultat =  repository.findById(id);

        if(resultat.isPresent()){
            repository.delete(resultat.get());
            return 1L;
        } else {
            return 0L;
        }
    }
}

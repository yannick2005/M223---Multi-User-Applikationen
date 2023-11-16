package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ch.zli.m223.model.Canteen;

import javax.persistence.EntityManager;

@ApplicationScoped
public class CanteenService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Canteen createCanteen(Canteen canteen) {
        entityManager.persist(canteen);
        return canteen;
    }

    @SuppressWarnings("unchecked")
    public List<Canteen> findAll() {
        var query = entityManager.createQuery("FROM Canteen");
        return query.getResultList();
    }

    public Canteen findById(Long id){
        var canteen = entityManager.find(Canteen.class, id);
        return canteen;
    }

    @Transactional
    public void deleteCanteen(long id) {
        var canteen = entityManager.find(Canteen.class, id);
        if (canteen != null) {
            entityManager.remove(canteen);
        }
    }    
}

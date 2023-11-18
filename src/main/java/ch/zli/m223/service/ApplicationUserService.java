package ch.zli.m223.service;

import ch.zli.m223.model.ApplicationUser;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    EntityManager entityManager;

    public List<ApplicationUser> listAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    public ApplicationUser findUserById(int id) {
        return entityManager.find(ApplicationUser.class, id);
    }

    @Transactional
    public ApplicationUser createUser(ApplicationUser user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public ApplicationUser updateUser(int id, ApplicationUser user) {
        user.setId(id);
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(int id) {
        ApplicationUser entity = entityManager.find(ApplicationUser.class, id);
        entityManager.remove(entity);
    }
}

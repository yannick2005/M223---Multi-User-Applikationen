package ch.zli.m223.service;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    EntityManager entityManager;
    // private Boolean isFirstTime = true; // I made this because the user table will not be empty after the implementation of the testData.

    public List<ApplicationUser> listAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    public ApplicationUser findUserById(int id) {
        return entityManager.find(ApplicationUser.class, id);
    }

    @Transactional
    public ApplicationUser createUser(ApplicationUser user) {
        List<ApplicationUser> allUsers = listAll();
        Role role = new Role();
        if (allUsers == null || allUsers.isEmpty() /*|| isFirstTime*/){ // Just a double check.
            role.setRoleName("admin");
        }
        else {
            role.setRoleName("member");
        }
        entityManager.persist(role);
        user.setRole(role);
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

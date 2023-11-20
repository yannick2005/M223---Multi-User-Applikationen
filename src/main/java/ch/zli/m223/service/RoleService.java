package ch.zli.m223.service;

import ch.zli.m223.model.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RoleService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public List<Role> listAll() {
        var query = entityManager.createQuery("FROM Role", Role.class);
        return query.getResultList();
    }

    @Transactional
    public Role findById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    public Role create(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Transactional
    public Role update(int id, Role role) {
        Role entity = entityManager.find(Role.class, id);
        String roleAsString = role.toString();
        entity.setRoleName(roleAsString);
        return entity;
    }

    @Transactional
    public void delete(int id) {
        Role entity = entityManager.find(Role.class, id);
        entityManager.remove(entity);
    }
    
}
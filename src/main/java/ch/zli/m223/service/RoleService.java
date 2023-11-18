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
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    public Role create(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Transactional
    public Role update(Long id, Role role) {
        Role entity = entityManager.find(Role.class, id);
        entity.setRole(role.getRole());
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        Role entity = entityManager.find(Role.class, id);
        entityManager.remove(entity);
    }
    
}
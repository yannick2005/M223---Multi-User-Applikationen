package ch.zli.m223.service;
import ch.zli.m223.model.Room;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class RoomService {

    @Inject
    private EntityManager entityManager;

    public List<Room> findAll() {
        var query = entityManager.createQuery("FROM Room", Room.class);
        return query.getResultList();
    }

    public Room findById(Long id){
        return entityManager.find(Room.class, id);
    }


    @Transactional
    public Room createRoom(Room room) {
        entityManager.persist(room);
        return room;
    }

    @Transactional
    public Room updateRoom(Long id, Room room) {
        return entityManager.merge(room);
    }

    @Transactional
    public void deleteRoom(Long id) {
        var bereich = entityManager.find(Room.class, id);
        entityManager.remove(bereich);
    }

    
}
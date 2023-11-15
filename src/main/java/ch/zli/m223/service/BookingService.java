package ch.zli.m223.service;

import ch.zli.m223.model.Booking;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class BookingService {

    @Inject
    EntityManager entityManager;

    public List<Booking> listAll(){
        var query = entityManager.createQuery("FROM Booking", Booking.class)
        return query.getResultList();
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    @Transactional
    public Booking updateBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public void delteBooking(Long id){
        Booking entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }
}

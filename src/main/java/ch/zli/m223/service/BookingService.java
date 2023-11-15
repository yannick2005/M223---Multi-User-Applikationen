package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import javax.persistence.EntityManager;

@ApplicationScoped
public class BookingService {
    @Inject
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking");
        return query.getResultList();
    }

    public Booking findById(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }    

    @Transactional
    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return entityManager.merge(booking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        Booking booking = entityManager.find(Booking.class, id);
        entityManager.remove(booking);
    }
}

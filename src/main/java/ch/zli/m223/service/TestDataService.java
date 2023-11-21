package ch.zli.m223.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Canteen;
import ch.zli.m223.model.Gender;
import ch.zli.m223.model.Role;
import ch.zli.m223.model.Room;
import ch.zli.m223.model.Status;
import io.quarkus.runtime.StartupEvent;

public class TestDataService {
    @Inject
    EntityManager entityManager;

    @Transactional
    void initalizeTestData(@Observes StartupEvent event) {
        Role adminRole = new Role();
        adminRole.setRoleName("admin");
        entityManager.persist(adminRole);

        Role memberRole = new Role();
        memberRole.setRoleName("member");
        entityManager.persist(memberRole);

        Role userRole = new Role(); // Only made to delete it in postman again, since role with relations are not allowed to be deleted nor updated.
        userRole.setRoleName("user");
        entityManager.persist(userRole);

        Room room = new Room();
        room.setTitle("Uranus");
        room.setFree(true);
        entityManager.persist(room);

        Room room2 = new Room();
        room2.setTitle("Pluto");
        room2.setFree(false);
        entityManager.persist(room2);

        Canteen canteen = new Canteen();
        canteen.setName("Fiji");
        canteen.setPrice(5.5);

        ApplicationUser adminUser = new ApplicationUser();
        adminUser.setFirstname("Sven");
        adminUser.setLastname("Svenson");
        adminUser.setEmail("s.svenson@example.com");
        adminUser.setPassword("Sui");
        adminUser.setGender(Gender.MALE);
        adminUser.setAge(18);
        adminUser.setRole(adminRole);
        entityManager.persist(adminUser);

        ApplicationUser memberUser = new ApplicationUser();
        memberUser.setFirstname("Manu");
        memberUser.setLastname("Manuelson");
        memberUser.setEmail("m.manuelson@example.com");
        memberUser.setPassword("Mui");
        memberUser.setGender(Gender.MALE);
        memberUser.setAge(18);
        memberUser.setRole(memberRole);
        entityManager.persist(memberUser);

        Booking adminBooking = new Booking();
        Date startDate = new Date(0);
        Date endDate = new Date(0);
        adminBooking.setTitle("adminBooking");
        adminBooking.setStartDate(startDate);
        adminBooking.setEndDate(endDate);
        adminBooking.setHalfDay(true);
        adminBooking.setRoom(room);
        adminBooking.setStatus(Status.ACCEPTED);
        adminBooking.setUser(new HashSet<>(Arrays.asList(adminUser)));
        entityManager.persist(adminBooking);

        Booking memberBooking = new Booking();
        Date secondStartDate = new Date(1);
        Date secondEndDate = new Date(1);
        memberBooking.setTitle("memberBooking");
        memberBooking.setStartDate(secondStartDate);
        memberBooking.setEndDate(secondEndDate);
        memberBooking.setHalfDay(false);
        memberBooking.setRoom(room);
        memberBooking.setStatus(Status.PENDING);
        memberBooking.setUser(new HashSet<>(Arrays.asList(memberUser)));
        entityManager.persist(memberBooking);

        Booking unusedBooking = new Booking(); // Also only made to delete it in postman again
        Date thirdStartDate = new Date(2);
        Date thirdEndDate = new Date(2);
        unusedBooking.setTitle("unusedBooking");
        unusedBooking.setStartDate(thirdStartDate);
        unusedBooking.setEndDate(thirdEndDate);
        unusedBooking.setStatus(Status.DECLINED);
        entityManager.persist(unusedBooking);
    }
}

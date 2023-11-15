package ch.zli.m223.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private boolean free;

    @OneToMany(mappedBy = "room")
    private List<Booking> booking = new ArrayList<Booking>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean getFree() {
        return this.free;
    }

    public List<Booking> getBooking() {
        return this.booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}

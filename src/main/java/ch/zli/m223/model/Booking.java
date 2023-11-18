package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Set;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private Status Status;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private boolean halfDay;

    @OneToMany(mappedBy = "booking")
    @JsonIgnoreProperties("booking")
    @Fetch(FetchMode.JOIN)
    private Set<ApplicationUser> user;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Room room;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ch.zli.m223.model.Status getStatus() {
        return Status;
    }

    public void setStatus(ch.zli.m223.model.Status status) {
        Status = status;
    }

    public Set<ApplicationUser> getUser() {
        return user;
    }

    public void setUser(Set<ApplicationUser> user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isHalfDay() {
        return halfDay;
    }

    public void setHalfDay(boolean halfDay) {
        this.halfDay = halfDay;
    }
}

package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Canteen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private long id;

    @Column
    private String name;

    @Column
    private float price;

    @ManyToMany(mappedBy = "canteens")
    @JsonIgnoreProperties("canteens")
    @Fetch(FetchMode.JOIN)
    private Set<ApplicationUser> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<ApplicationUser> getUsers() {
        return this.users;
    }

    public void setUsers(Set<ApplicationUser> users) {
        this.users = users;
    }
}

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
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "canteens")
    @JsonIgnoreProperties("canteens")
    @Fetch(FetchMode.JOIN)
    private Set<ApplicationUser> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<ApplicationUser> getUsers() {
        return users;
    }

    public void setUsers(Set<ApplicationUser> users) {
        this.users = users;
    }
}

package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "canteen")
public class Canteen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private long id;

    @Column
    private String name;

    @Column
    private float price;

    @ManyToMany(mappedBy = "canteen_users")
    @JsonIgnoreProperties("canteen_users")
    @Fetch(FetchMode.JOIN)
    private Set<User> users;

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

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

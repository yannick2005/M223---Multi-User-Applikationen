package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private long id;

    @Column(nullable = false)
    @Size(min = 1, max = 20)
    private String firstname;

    @Column
    @Size(min = 1, max = 20)
    private String lastname;

    @Column
    private Gender Gender;

    @Column(nullable = false)
    @Email
    @NotEmpty
    private String email;
    
    @Column(nullable = false)
    @NotEmpty
    private String password;
    private int age;
    
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Booking booking;
    
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Role role;
    
    @Size(min = 1, max = 20)
    private String description;

    @ManyToMany
    @JoinTable(
        name = "user_canteens",
        joinColumns = @JoinColumn(name = "applicationUser_id"),
        inverseJoinColumns = @JoinColumn(name = "canteen_id")
    )
    @JsonIgnoreProperties("users")
    @Fetch(FetchMode.JOIN)
    private Set<Canteen> canteens;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ch.zli.m223.model.Gender getGender(){
        return Gender;
    }

    public void setGender(ch.zli.m223.model.Gender gender){
        Gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Booking getBooking(){
        return booking;
    }

    public void setBooking(Booking booking){
        this.booking = booking;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public Set<Canteen> getCanteens(){
        return canteens;
    }

    public void setCanteens(Set<Canteen> canteens){
        this.canteens = canteens;
    }

}
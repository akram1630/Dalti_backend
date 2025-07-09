package org.example.book.dalti_back.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//drop table i u forget this
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String profilePic;

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @ManyToMany(mappedBy = "clients" , fetch = FetchType.EAGER)
    private Set<Service> services =  new HashSet<>();

    /// //////////////////////////////////////////////////////////
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    //must to make remove() run ,  if u have a Set or List
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client person = (Client) o;
        return id != null && id.equals(person.id);
    }
    @Override
    public int hashCode() {
        return 31;
    }



}

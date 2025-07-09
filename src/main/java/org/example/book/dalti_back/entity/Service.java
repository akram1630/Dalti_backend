package org.example.book.dalti_back.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //user

    private String name;

    private String profilePic;

    private String  address;
    private String email;

    private String phone;

    private String commercialNumber;

    private int totalGuichet;

    private String averageTimePerson;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "service_category",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    //@JsonBackReference // @JsonBackReference tells Jackson:Don’t serialize this field — it’s the back side of a bidirectional relationship
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "service_client",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients = new HashSet<>();
/// ///////////////////////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCommercialNumber() {
        return commercialNumber;
    }

    public void setCommercialNumber(String commercialNumber) {
        this.commercialNumber = commercialNumber;
    }

    public int getTotalGuichet() {
        return totalGuichet;
    }

    public void setTotalGuichet(int totalGuichet) {
        this.totalGuichet = totalGuichet;
    }

    public String getAverageTimePerson() {
        return averageTimePerson;
    }

    public void setAverageTimePerson(String averageTimePerson) {
        this.averageTimePerson = averageTimePerson;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> category) {
        this.categories = category;
    }

    public Set<Client> getClients() {
        return clients;
    }
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }


    //must to make remove() run , if u have a Set or List
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service person = (Service) o;
        return id != null && id.equals(person.id);
    }
    @Override
    public int hashCode() {
        return 31;
    }


}


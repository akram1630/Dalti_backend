package org.example.book.dalti_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "category")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;

    private String profilePic;


    @JsonIgnore
    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private List<Service> services = new ArrayList<>();

/////////////////////////////////////////////////////////////////
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    //must to make remove() run , if u have a Set or List
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category person = (Category) o;
        return id != null && id.equals(person.id);
    }
    @Override
    public int hashCode() {
        return 31;
    }

}

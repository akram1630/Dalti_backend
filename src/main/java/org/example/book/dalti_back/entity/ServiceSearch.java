package org.example.book.dalti_back.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

public class ServiceSearch {


    private String name;
    private String address;
    private String email;
    private String phone;
    private String commercialNumber;

    /// ///////////////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}

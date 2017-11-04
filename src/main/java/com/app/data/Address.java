package com.app.data;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 3/22/17.
 */
//Test Test
@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name="address_seq", sequenceName = "address_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String addressLine1;
    private String addressLine2;
    private String street;
    private String city;
    private String state;
    private String country;
    private String poBox;

    @ManyToOne
    private Geolocation geolocation;

    public Address() { }

    public Address(String addressLine1, String addressLine2, String street, String city, String state, String country, String poBox, Geolocation geolocation) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.poBox = poBox;
        this.geolocation = geolocation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }
}

package com.app.data;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 3/22/17.
 */

@Entity
public class ContactInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactinfo_seq")
    @SequenceGenerator(name="contactinfo_seq", sequenceName = "contactinfo_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String phone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    public ContactInfo() { }

    public ContactInfo(String phone, String email, Address address) {
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

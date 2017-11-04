package com.app.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by wailm.yousif on 10/21/17.
 */

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ApiUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apiuser_seq")
    @SequenceGenerator(name="apiuser_seq", sequenceName = "apiuser_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    private LocalDateTime creationTime;
    private boolean enabled;

    public ApiUser() { }

    public ApiUser(String username, String password, LocalDateTime creationTime, boolean enabled) {
        this.username = username;
        this.password = password;
        this.creationTime = creationTime;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

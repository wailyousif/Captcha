package com.app.data;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 10/21/17.
 */

@Entity
public class Geolocation
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geolocation_seq")
    @SequenceGenerator(name="geolocation_seq", sequenceName = "geolocation_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private double lat;
    private double lng;

    public Geolocation() { }

    public Geolocation(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}

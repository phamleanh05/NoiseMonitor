package com.java.NoiseMonitor.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sound")
public class Sound {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)

    private Integer id;
    private Double Decibels;
    private String area;
    private Date time;
    private Double lat;
    private Double lng;

    public Sound() {
    }

    public Sound(Integer id, Double Decibels, String area, Date time, Double lat, Double lng) {
        this.id = id;
        this.Decibels = Decibels;
        this.area = area;
        this.time = time;
        this.lat = lat;
        this.lng = lng;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDecibels() {
        return Decibels;
    }

    public void setDecibels(Double Decibels) {
        this.Decibels = Decibels;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "CurrentSound{" +
                "id=" + id +
                ", Decibels=" + Decibels +
                ", area=" + area +
                ", time=" + time +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}

package com.java.NoiseMonitor.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)

    private UUID uuid;
    private Integer locationId;
    private Integer soundId;
    private String area;
    private Double lat;
    private Double lng;

    public Location(UUID uuid, Integer locationId, Integer soundId, String area, Double lat, Double lng) {
        this.uuid = uuid;
        this.locationId = locationId;
        this.soundId = soundId;
        this.area = area;
        this.lat = lat;
        this.lng = lng;
    }

    public Location() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getSoundId() {
        return soundId;
    }

    public void setSoundId(Integer soundId) {
        this.soundId = soundId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
        return "Location{" +
                "uuid=" + uuid +
                ", locationId=" + locationId +
                ", soundId=" + soundId +
                ", area='" + area + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}

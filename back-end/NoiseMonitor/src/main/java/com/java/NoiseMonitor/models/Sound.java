package com.java.NoiseMonitor.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "sound")
public class Sound {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)

    private UUID uuid;
    private Integer locationId;
    private Integer soundId;
    private Double Decibels;
    private Date time;

    public Sound() {
    }

    public Sound(UUID uuid, Integer locationId, Integer soundId, Double decibels, Date time) {
        this.uuid = uuid;
        this.locationId = locationId;
        this.soundId = soundId;
        this.Decibels = decibels;
        this.time = time;
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

    public Double getDecibels() {
        return Decibels;
    }

    public void setDecibels(Double decibels) {
        Decibels = decibels;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Sound{" +
                "uuid=" + uuid +
                ", locationId=" + locationId +
                ", soundId=" + soundId +
                ", Decibels=" + Decibels +
                ", time=" + time +
                '}';
    }
}

package com.java.NoiseMonitor.models;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class DefaultArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String area_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public DefaultArea(Integer id, String area_name) {
        this.id = id;
        this.area_name = area_name;
    }

    @Override
    public String toString() {
        return "DefaultArea{" +
                "id=" + id +
                ", area_name='" + area_name + '\'' +
                '}';
    }
}

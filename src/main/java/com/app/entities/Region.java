package com.app.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwa;
    @Column(columnDefinition="LONGTEXT")
    private String opis;

    @ManyToMany
    private List<Uprawa> uprawy = new ArrayList<>();
    public Region() {
    }

    public Region(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Uprawa> getUprawy() {
        return uprawy;
    }

    public void setUprawy(List<Uprawa> uprawy) {
        this.uprawy = uprawy;
    }
}

package com.app.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Zagrozenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwa;
    @Column(columnDefinition="LONGTEXT")
    private String opis;
    @ManyToMany
    private List<Ochrona> ochrony = new ArrayList();
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @ManyToMany(mappedBy = "zagrozenia")
    private List<Uprawa> uprawy = new ArrayList<>();

    public Zagrozenie() {
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

    public List<Ochrona> getOchrony() {
        return ochrony;
    }

    public void setOchrony(List<Ochrona> ochrony) {
        this.ochrony = ochrony;
    }

    public List<Uprawa> getUprawy() {
        return uprawy;
    }

    public void setUprawy(List<Uprawa> uprawy) {
        this.uprawy = uprawy;
    }
}
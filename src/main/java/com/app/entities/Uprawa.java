package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Uprawa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwa;
    @Column(columnDefinition="LONGTEXT")
    private String opis;
    @ManyToMany
    private List<Zagrozenie> zagrozenia = new ArrayList();
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @ManyToMany(mappedBy = "uprawy")
    private List<Region> regiony = new ArrayList<>();

    public Uprawa() {
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

    public List<Zagrozenie> getZagrozenia() {
        return zagrozenia;
    }

    public void setZagrozenia(List<Zagrozenie> zagrozenia) {
        this.zagrozenia = zagrozenia;
    }

    public List<Region> getRegiony() {
        return regiony;
    }

    public void setRegiony(List<Region> regiony) {
        this.regiony = regiony;
    }

}

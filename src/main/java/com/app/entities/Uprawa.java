package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Blob;
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
    private String nazwaPliku;
//    private byte[] plik;
    @ManyToMany
    private List<Zagrozenie> zagrozenia = new ArrayList();
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @ManyToMany(mappedBy = "uprawy")
    private List<Region> regiony = new ArrayList<>();


    @Column(columnDefinition = "LONGTEXT")
    private String image;

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

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public void setNazwaPliku(String nazwaPliku) {
        this.nazwaPliku = nazwaPliku;
    }

//    public byte[] getPlik() {
//        return plik;
//    }
//
//    public void setPlik(byte[] plik) {
//        this.plik = plik;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

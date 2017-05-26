package com.app.services;

import com.app.entities.Ochrona;
import com.app.entities.Region;
import com.app.entities.Uprawa;
import com.app.entities.Zagrozenie;
import com.app.entities.dto.NazwaIOpis;
import com.app.entities.dto.IdAndIds;
import com.app.repositories.OchronaRepository;
import com.app.repositories.RegionRepository;
import com.app.repositories.UprawaRepository;
import com.app.repositories.ZagrozenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PreRemove;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CrudService {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private UprawaRepository uprawaRepository;
    @Autowired
    private ZagrozenieRepository zagrozenieRepository;
    @Autowired
    private OchronaRepository ochronaRepository;

    public boolean dodajRegion(NazwaIOpis nazwaIOpis) {
        Region region = new Region(nazwaIOpis.getNazwa(),nazwaIOpis.getOpis());
        regionRepository.save(region);
        if(Optional.ofNullable(region.getId()).isPresent())
            return true;
        else
            return false;
    }

    public boolean dodajUprawe(NazwaIOpis nazwaIOpis) {
        Uprawa uprawa = new Uprawa();
        uprawa.setNazwa(nazwaIOpis.getNazwa());
        uprawa.setOpis(nazwaIOpis.getOpis());
        uprawaRepository.save(uprawa);
        if(Optional.ofNullable(uprawa.getId()).isPresent())
            return true;
        else
            return false;
    }

    public boolean dodajZagrozenie(NazwaIOpis nazwaIOpis) {
        Zagrozenie zagrozenie = new Zagrozenie();
        zagrozenie.setNazwa(nazwaIOpis.getNazwa());
        zagrozenie.setOpis(nazwaIOpis.getOpis());
        zagrozenieRepository.save(zagrozenie);
        if(Optional.ofNullable(zagrozenie.getId()).isPresent())
            return true;
        else
            return false;
    }

    public boolean dodajOchrone(NazwaIOpis nazwaIOpis) {
        Ochrona ochrona = new Ochrona();
        ochrona.setNazwa(nazwaIOpis.getNazwa());
        ochrona.setOpis(nazwaIOpis.getOpis());
        ochronaRepository.save(ochrona);
        if(Optional.ofNullable(ochrona.getId()).isPresent())
            return true;
        else
            return false;

    }

    public List<Region> znajdzWszystkieRegiony() {
        return regionRepository.findAll();
    }

    public Optional<Region> znajdzJedenRegion(Long id) {
        return Optional.ofNullable(regionRepository.findOne(id));
    }
    public List<Uprawa> znajdzWszystkieUprawy() {
        return uprawaRepository.findAll();
    }

    public boolean przypiszUprawyDoRegionu(IdAndIds regionIUprawy){
        boolean zmodyfikowano = false;
        try{
            Region region = regionRepository.findOne(regionIUprawy.getId());
            if(region!=null){
                for(Long idUprawy : regionIUprawy.getIds()){
                    Uprawa uprawa = uprawaRepository.findOne(idUprawy);
                    if(!region.getUprawy().contains(uprawa)){
                        region.getUprawy().add(uprawa);
                    }
                }
                zmodyfikowano = true;
            }
            return zmodyfikowano;
        }catch (Exception e){
            e.printStackTrace();
            return zmodyfikowano;
        }
    }

    public List<Zagrozenie> znajdzWszystkieZagrozenia() {
        return zagrozenieRepository.findAll();
    }
    public boolean przypiszZagrozeniaDoUprawy(IdAndIds uprawaIZagrozenia){
        boolean zmodyfikowano = false;
        try{
            Uprawa uprawa = uprawaRepository.findOne(uprawaIZagrozenia.getId());
            if(uprawa!=null){
                for(Long idZagrozenia : uprawaIZagrozenia.getIds()){
                    Zagrozenie zagrozenie = zagrozenieRepository.findOne(idZagrozenia);
                    if(!uprawa.getZagrozenia().contains(zagrozenie)){
                        uprawa.getZagrozenia().add(zagrozenie);
                    }
                }
                zmodyfikowano = true;
            }
            return zmodyfikowano;
        }catch (Exception e){
            e.printStackTrace();
            return zmodyfikowano;
        }
    }
    public Optional<Uprawa> znajdzJednaUprawe(Long id) {
        return Optional.ofNullable(uprawaRepository.findOne(id));
    }

    public List<Ochrona> znajdzWszystkieOchrony() {
        return ochronaRepository.findAll();
    }

    public boolean przypiszOchronyDoZagrozenia(IdAndIds zagrozenieIOchrony){
        boolean zmodyfikowano = false;
        try{
            Zagrozenie zagrozenie = zagrozenieRepository.findOne(zagrozenieIOchrony.getId());
            if(zagrozenie!=null){
                for(Long idOchrony : zagrozenieIOchrony.getIds()){
                    Ochrona ochrona = ochronaRepository.findOne(idOchrony);
                    if(!zagrozenie.getOchrony().contains(ochrona)){
                        zagrozenie.getOchrony().add(ochrona);
                    }
                }
                zmodyfikowano = true;
            }
            return zmodyfikowano;
        }catch (Exception e){
            e.printStackTrace();
            return zmodyfikowano;
        }
    }

    public Optional<Zagrozenie> znajdzJedenoZagrozenie(Long id) {
        return Optional.ofNullable(zagrozenieRepository.findOne(id));
    }

    public Optional<Ochrona> znajdzJedenoOchrone(Long id) {
        return Optional.ofNullable(ochronaRepository.findOne(id));
    }

    public boolean edytujRegion(Region region){
        boolean isModifed = false;
        Optional<Region> regionOptional = znajdzJedenRegion(region.getId());
        if(regionOptional.isPresent()){
            Region istniejacyRegion = regionOptional.get();
            istniejacyRegion.setNazwa(region.getNazwa());
            istniejacyRegion.setOpis(region.getOpis());
            isModifed = true;
        }
        return isModifed;
    }

    public boolean edytujUprawe(Uprawa uprawa){
        boolean isModifed = false;
        Optional<Uprawa> uprawaOptional = znajdzJednaUprawe(uprawa.getId());
        if(uprawaOptional.isPresent()){
            Uprawa istniejacaUprawa = uprawaOptional.get();
            istniejacaUprawa.setNazwa(uprawa.getNazwa());
            istniejacaUprawa.setOpis(uprawa.getOpis());
            isModifed = true;
        }
        return isModifed;
    }

    public boolean edytujZagrozenie(Zagrozenie zagrozenie){
        boolean isModifed = false;
        Optional<Zagrozenie> zagrozenieOptional = znajdzJedenoZagrozenie(zagrozenie.getId());
        if(zagrozenieOptional.isPresent()){
            Zagrozenie istniejaceZagrozenie = zagrozenieOptional.get();
            istniejaceZagrozenie.setNazwa(zagrozenie.getNazwa());
            istniejaceZagrozenie.setOpis(zagrozenie.getOpis());
            isModifed = true;
        }
        return isModifed;
    }

    public boolean edytujOchrone(Ochrona ochrona){
        boolean isModifed = false;
        Optional<Ochrona> ochronaOptional = znajdzJedenoOchrone(ochrona.getId());
        if(ochronaOptional.isPresent()){
            Ochrona istniejacaOchrona = ochronaOptional.get();
            istniejacaOchrona.setNazwa(ochrona.getNazwa());
            istniejacaOchrona.setOpis(ochrona.getOpis());
            isModifed = true;
        }
        return isModifed;
    }

    @PreRemove
    public void usunUprawe(long id){
        Optional<Uprawa> uprawa = znajdzJednaUprawe(id);
        if(uprawa.isPresent()){
            uprawaRepository.usunPowiazania(id);
            uprawaRepository.delete(id);
        }
    }
}

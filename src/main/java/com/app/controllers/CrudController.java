package com.app.controllers;

import com.app.entities.Ochrona;
import com.app.entities.Region;
import com.app.entities.Uprawa;
import com.app.entities.Zagrozenie;
import com.app.entities.dto.NazwaIOpis;
import com.app.entities.dto.IdAndIds;
import com.app.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/")
public class CrudController {
    @Autowired
    private CrudService crudService;

    @GetMapping("/region/wszystkie")
    public ResponseEntity<?> znajdzWszystkieRegiony() {
        List<Region> allRegions = crudService.znajdzWszystkieRegiony();
        if (!allRegions.isEmpty())
            return ResponseEntity.ok(allRegions);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/region/id/{id}")
    public ResponseEntity<?> znajdzJedenRegion(@PathVariable Long id) {
        Optional<Region> region = crudService.znajdzJedenRegion(id);
        if (region.isPresent())
            return ResponseEntity.ok(region.get());
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/region/dodaj")
    public ResponseEntity<?> dodajRegion(@RequestBody NazwaIOpis nazwaIOpis) {
        boolean isAdded = crudService.dodajRegion(nazwaIOpis);
        if (isAdded) {
            return ResponseEntity.ok(isAdded);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isAdded);
    }
    @PostMapping(value = "/uprawa/dodaj")
    public ResponseEntity<?> dodajUprawe(@RequestBody NazwaIOpis nazwaIOpis) {
        boolean isAdded = crudService.dodajUprawe(nazwaIOpis);
        if (isAdded) {
            return ResponseEntity.ok(isAdded);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isAdded);
    }
    @PostMapping(value = "/zagrozenie/dodaj")
    public ResponseEntity<?> dodajZagrozenie(@RequestBody NazwaIOpis nazwaIOpis) {
        boolean isAdded = crudService.dodajZagrozenie(nazwaIOpis);
        if (isAdded) {
            return ResponseEntity.ok(isAdded);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isAdded);
    }
    @PostMapping(value = "/ochrona/dodaj")
    public ResponseEntity<?> dodajOchrone(@RequestBody NazwaIOpis nazwaIOpis) {
        boolean isAdded = crudService.dodajOchrone(nazwaIOpis);
        if (isAdded) {
            return ResponseEntity.ok(isAdded);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isAdded);
    }

    @GetMapping("/uprawa/wszystkie")
    public ResponseEntity<?> znajdzWszystkieUprawy() {
        List<Uprawa> uprawy = crudService.znajdzWszystkieUprawy();
        if (!uprawy.isEmpty())
            return ResponseEntity.ok(uprawy);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/przypisz/uprawy/do/regionu")
    public ResponseEntity<?> przypiszUprawyDoRegiony(@RequestBody IdAndIds regionIuprawy) {
        boolean zmodyfikowano = crudService.przypiszUprawyDoRegionu(regionIuprawy);
        if(zmodyfikowano){
            return ResponseEntity.ok(zmodyfikowano);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(zmodyfikowano);
        }
    }

    @GetMapping("/zagrozenia/wszystkie")
    public ResponseEntity<?> znajdzWszystkieZagrozenia() {
        List<Zagrozenie> zagrozenia = crudService.znajdzWszystkieZagrozenia();
        if (!zagrozenia.isEmpty())
            return ResponseEntity.ok(zagrozenia);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/przypisz/zagrozenia/do/uprawy")
    public ResponseEntity<?> przypiszZagrozeniaDoUprawy(@RequestBody IdAndIds uprawaIzagrozenia) {
        boolean zmodyfikowano = crudService.przypiszZagrozeniaDoUprawy(uprawaIzagrozenia);
        if(zmodyfikowano){
            return ResponseEntity.ok(zmodyfikowano);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(zmodyfikowano);
        }
    }

    @GetMapping("/uprawa/id/{id}")
    public ResponseEntity<?> znajdzJednaUprawe(@PathVariable Long id) {
        Optional<Uprawa> uprawa = crudService.znajdzJednaUprawe(id);
        if (uprawa.isPresent())
            return ResponseEntity.ok(uprawa.get());
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ochrony/wszystkie")
    public ResponseEntity<?> znajdzWszystkieOchrony() {
        List<Ochrona> ochrony = crudService.znajdzWszystkieOchrony();
        if (!ochrony.isEmpty())
            return ResponseEntity.ok(ochrony);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/przypisz/ochrony/do/zagrozenia")
    public ResponseEntity<?> przypiszOchronyDoZagrozenia(@RequestBody IdAndIds zagrozenieIOchrony) {
        boolean zmodyfikowano = crudService.przypiszOchronyDoZagrozenia(zagrozenieIOchrony);
        if(zmodyfikowano){
            return ResponseEntity.ok(zmodyfikowano);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(zmodyfikowano);
        }
    }

    @GetMapping("/zagrozenie/id/{id}")
    public ResponseEntity<?> znajdzJednoZagrozenie(@PathVariable Long id) {
        Optional<Zagrozenie> zagrozenie = crudService.znajdzJedenoZagrozenie(id);
        if (zagrozenie.isPresent())
            return ResponseEntity.ok(zagrozenie.get());
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/region/edytuj")
    public ResponseEntity<?> edytujRegion(@RequestBody Region region) {
        boolean zmodyfikowano = crudService.edytujRegion(region);
        if(zmodyfikowano){
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
        }
    }
    @PostMapping("/uprawa/edytuj")
    public ResponseEntity<?> edytujUprawa(@RequestBody Uprawa uprawa) {
        boolean zmodyfikowano = crudService.edytujUprawe(uprawa);
        if(zmodyfikowano){
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
        }
    }
    @PostMapping("/zagrozenie/edytuj")
    public ResponseEntity<?> edytujZagrozenie(@RequestBody Zagrozenie zagrozenie) {
        boolean zmodyfikowano = crudService.edytujZagrozenie(zagrozenie);
        if(zmodyfikowano){
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
        }
    }
    @PostMapping("/ochrona/edytuj")
    public ResponseEntity<?> edytujOchrone(@RequestBody Ochrona ochrona) {
        boolean zmodyfikowano = crudService.edytujOchrone(ochrona);
        if(zmodyfikowano){
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/ochrona/id/{id}")
    public ResponseEntity<?> znajdzJednoOchrone(@PathVariable Long id) {
        Optional<Ochrona> ochrona = crudService.znajdzJedenoOchrone(id);
        if (ochrona.isPresent())
            return ResponseEntity.ok(ochrona.get());
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

}

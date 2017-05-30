package com.app.services;

import com.app.entities.AppUser;
import com.app.entities.Region;
import com.app.entities.Role;
import com.app.entities.Uprawa;
import com.app.repositories.RegionRepository;
import com.app.repositories.UprawaRepository;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Init {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UprawaRepository uprawaRepository;

    @Autowired
    private RegionRepository regionRepository;

    @PostConstruct
    public void init(){

        List<Region> region = new ArrayList<>();
        region.add(new Region("Podkarpackie", "W użytkowaniu gospodarstw rolnych znajduje się 763,3 tys.ha tj. 42,8% ogólnej powierzchni województwa. Za gospodarstwo rolne uważa się wyodrębnioną pod względem ekonomicznym i technicznym jednostkę prowadzącą działalność rolniczą, a więc uprawę roślin oraz chów i hodowlę zwierząt"));
        region.add(new Region("Małopolskie", "Województwo małopolskie charakteryzuje się zróżnicowanym ukształtowaniem terenu i warunkami klimatycznymi. W części północnej województwa (powiat miechowski, proszowicki i częściowo krakowski) gleby są zdecydowanie lepsze a klimat sprzyja produkcji rolnej, przez co właśnie tam dominują gospodarstwa większe i nastawione na produkcję żywności na rynek. Część środkowa województwa (między innymi powiaty bocheński, wielicki, część krakowskiego i tarnowskiego) znajduje się pod mocnym wpływem dużych aglomeracji miejskich Krakowa i Tarnowa, a ludność zamieszkująca te obszary z reguły właśnie tam poszukuje zatrudnienia, w rolnictwie widząc jedynie dodatkowe źródło dochodu. Bardziej górzysta część południowa województwa obejmuje tereny cenne pod względem przyrodniczym, ale o niekorzystnych warunkach do produkcji rolnej między innymi ze względu na ostrzejszy klimat i niesprzyjające ukształtowanie terenu. Gospodarstwa z tego rejonu są małe, grunty rozdrobnione, a ludność poszukuje zatrudnienia z reguły poza rolnictwem. Dominuje tradycyjny model gospodarowania co często bywa wykorzystywane jako atut przy poszukiwaniu odpowiedniej niszy rynkowej (agroturystyka, produkcja ekologiczna i regionalna)."));
        region.add(new Region("Świętokrzyskie", "Kielce"));
        region.add(new Region("Mazowieckie", "Warszawa"));
        region.add(new Region("Śląskie", "Katowice"));
        region.add(new Region("Wielkopolskie", "Poznań"));
        region.add(new Region("Dolnośląskie", "Wrocław"));
        region.add(new Region("Łódzkie", "Łódź"));
        region.add(new Region("Pomorskie", "Gdańsk"));
        region.add(new Region("Lubelskie", "Lublin"));
        region.add(new Region("Kujawsko-pomorskie", "Bydgoszcz"));
        region.add(new Region("Zachodniopomorskie", "Szczecin"));
        region.add(new Region("Warmińsko-mazurskie", "Olsztyn"));
        region.add(new Region("Podlaskie", "Białystok"));
        region.add(new Region("Lubuskie", "Gorzów Wielkopolski i Zielona Góra"));
        region.add(new Region("Opolskie", "Opole"));

        for(Region r : region){
            Region byName = regionRepository.findByNazwa(r.getNazwa());
            if(byName==null){
                regionRepository.save(r);
            }
        }


        AppUser user = userRepository.findByEmail("admin@gmail.com");
        if(user==null){
            user = new AppUser();
            user.setEmail("admin@gmail.com");
            user.setFirstName("Giacomo");

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode("admin"));
            user.setRole(Role.ADMIN);
            userRepository.save(user);
        }
        AppUser user2 = userRepository.findByEmail("user@gmail.com");
        if(user2==null){
            user2 = new AppUser();
            user2.setEmail("user@gmail.com");
            user2.setFirstName("Marcin");

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user2.setPassword(encoder.encode("user"));
            user2.setRole(Role.USER);
            userRepository.save(user2);
        }
    }
}

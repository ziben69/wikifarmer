package com.app.repositories;

import com.app.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ziben on 2017-03-14.
 */
public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByNazwa(String name);

}

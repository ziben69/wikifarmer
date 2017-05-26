package com.app.repositories;

import com.app.entities.Uprawa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UprawaRepository extends JpaRepository<Uprawa,Long> {
    @Modifying
    @Query(value="DELETE FROM region_uprawy WHERE uprawy_id = ?1", nativeQuery=true)
    public void usunPowiazania(Long uprawyId);
}

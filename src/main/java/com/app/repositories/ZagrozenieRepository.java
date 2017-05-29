package com.app.repositories;

import com.app.entities.Zagrozenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ZagrozenieRepository extends JpaRepository<Zagrozenie,Long> {
    @Modifying
    @Query(value="DELETE FROM uprawa_zagrozenia WHERE zagrozenia_id = ?1", nativeQuery=true)
    public void usunPowiazania(Long zagrozenieId);
}

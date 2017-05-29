package com.app.repositories;

import com.app.entities.Ochrona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OchronaRepository extends JpaRepository<Ochrona, Long> {
    @Modifying
    @Query(value="DELETE FROM zagrozenie_ochrony WHERE ochrony_id = ?1", nativeQuery=true)
    public void usunPowiazania(Long ochronyId);
}

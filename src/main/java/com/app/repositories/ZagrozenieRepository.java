package com.app.repositories;

import com.app.entities.Zagrozenie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZagrozenieRepository extends JpaRepository<Zagrozenie,Long> {
}

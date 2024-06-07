package com.frc.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frc.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long>{   
    Optional<Mascota> findByName(String name);
}

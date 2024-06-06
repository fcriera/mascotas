package com.frc.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.frc.model.Mascota;

public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long>{
}

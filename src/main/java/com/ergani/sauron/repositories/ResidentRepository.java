package com.ergani.sauron.repositories;

import com.ergani.sauron.domain.Resident;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResidentRepository extends CrudRepository<Resident, Long> {
    public Optional<Resident> findByTrid(String trid);
}

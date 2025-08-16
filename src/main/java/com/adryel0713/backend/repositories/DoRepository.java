package com.adryel0713.backend.repositories;

import com.adryel0713.backend.model.Do;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoRepository extends JpaRepository<Do, Long> {

}

package com.argoden.genesis.dao.repo;

import com.argoden.genesis.dao.jpa.SpecieJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecieRepository extends JpaRepository<SpecieJpa, Long> {

}

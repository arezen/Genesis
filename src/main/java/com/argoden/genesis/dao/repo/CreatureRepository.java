package com.argoden.genesis.dao.repo;


import com.argoden.genesis.CreatureStatus;
import com.argoden.genesis.dao.jpa.CreatureJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreatureRepository extends JpaRepository<CreatureJpa, Long> {

    List<CreatureJpa> findAllByStatusOrderByScoreAsc(CreatureStatus status);

    @Query(value = "SELECT * FROM CREATURE ORDER BY SCORE DESC OFFSET :offset", nativeQuery = true)
    List<CreatureJpa> findAllUnfit(@Param("offset") Integer offset);

}

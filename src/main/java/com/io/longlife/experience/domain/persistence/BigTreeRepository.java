package com.io.longlife.experience.domain.persistence;

import com.io.longlife.experience.domain.model.entity.BigTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BigTreeRepository extends JpaRepository<BigTree, Long> {

    BigTree findByEmail(String email);
    BigTree findByUsername(String username);
}

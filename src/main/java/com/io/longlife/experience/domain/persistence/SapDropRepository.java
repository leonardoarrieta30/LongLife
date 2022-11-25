package com.io.longlife.experience.domain.persistence;

import com.io.longlife.experience.domain.model.entity.SapDrop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SapDropRepository extends JpaRepository<SapDrop, Long> {
}

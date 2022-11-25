package com.io.longlife.experience.domain.persistence;

import com.io.longlife.experience.domain.model.entity.GreenLeaf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenLeafRepository extends JpaRepository<GreenLeaf, Long> {



    GreenLeaf findByTitle(String title);
}

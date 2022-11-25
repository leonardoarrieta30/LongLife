package com.io.longlife.experience.domain.service;


import com.io.longlife.experience.domain.model.entity.GreenLeaf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GreenLeafService {
    List<GreenLeaf> getAll();
    Page<GreenLeaf> getAll(Pageable pageable);
    GreenLeaf getById(Long greenLeafId);
    GreenLeaf create(GreenLeaf greenLeaf);
    GreenLeaf update(Long greenLeafId, GreenLeaf request);
    ResponseEntity<?> delete(Long greenLeafId);
}

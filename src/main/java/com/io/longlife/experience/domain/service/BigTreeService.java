package com.io.longlife.experience.domain.service;

import com.io.longlife.experience.domain.model.entity.BigTree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BigTreeService {
    List<BigTree> getAll();
    Page<BigTree> getAll(Pageable pageable);
    BigTree getById(Long bigTreeId);
    BigTree create(BigTree bigTree);
    BigTree update(Long bigTreeId, BigTree request);
    ResponseEntity<?> delete(Long bigTreeId);
}

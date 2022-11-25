package com.io.longlife.experience.domain.service;

import com.io.longlife.experience.domain.model.entity.SapDrop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SapDropService {
    List<SapDrop> getAll();
    Page<SapDrop> getAll(Pageable pageable);
    SapDrop getById(Long sapDropId);
    SapDrop create(SapDrop sapDrop);
    SapDrop update(Long sapDropId, SapDrop request);
    ResponseEntity<?> delete(Long sapDropId);
}

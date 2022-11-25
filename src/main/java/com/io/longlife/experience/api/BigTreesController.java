package com.io.longlife.experience.api;

import com.io.longlife.experience.domain.service.BigTreeService;
import com.io.longlife.experience.mapping.BigTreeMapper;
import com.io.longlife.experience.resource.BigTreeResource;
import com.io.longlife.experience.resource.CreateBigTreeResource;
import com.io.longlife.experience.resource.UpdateBigTreeResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/trees", produces = "application/json")
@Tag(name = "Big Trees", description = "Create, read, update and delete BigTrees")
public class BigTreesController {
    public final BigTreeService bigTreeService;

    private final BigTreeMapper mapper;


    public BigTreesController(BigTreeService bigTreeService, BigTreeMapper mapper) {
        this.bigTreeService = bigTreeService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<BigTreeResource> getAllBigTrees(Pageable pageable){
        return mapper.modelListPage(bigTreeService.getAll(), pageable);
    }

    @GetMapping("{bigTreeId}")
    public BigTreeResource getBigTreeById(@PathVariable Long bigTreeId){
        return mapper.toResource(bigTreeService.getById(bigTreeId));
    }

    @PostMapping
    public ResponseEntity<BigTreeResource> createBigTree(@RequestBody CreateBigTreeResource resource){
        return new ResponseEntity<>(mapper.toResource(bigTreeService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{bigTreeId}")
    public BigTreeResource updateBigTree(@PathVariable Long bigTreeId, @RequestBody UpdateBigTreeResource resource){
        return mapper.toResource(bigTreeService.update(bigTreeId, mapper.toModel(resource)));
    }

    @DeleteMapping("{bigTreeId}")
    public ResponseEntity<?> deleteBigTree(@PathVariable Long bigTreeId) {
        return bigTreeService.delete(bigTreeId);
    }


}

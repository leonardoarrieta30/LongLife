package com.io.longlife.experience.service;

import com.io.longlife.experience.domain.model.entity.BigTree;
import com.io.longlife.experience.domain.persistence.BigTreeRepository;
import com.io.longlife.experience.domain.service.BigTreeService;
import com.io.longlife.shared.exception.ResourceNotFoundException;
import com.io.longlife.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BigTreeServiceImpl implements BigTreeService {

    private static final String ENTITY = "BigTree";

    private final BigTreeRepository bigTreeRepository;

    private final Validator validator;

    public BigTreeServiceImpl(BigTreeRepository bigTreeRepository, Validator validator) {
        this.bigTreeRepository = bigTreeRepository;
        this.validator = validator;
    }

    @Override
    public List<BigTree> getAll() {
        return bigTreeRepository.findAll();
    }

    @Override
    public Page<BigTree> getAll(Pageable pageable) {
        return bigTreeRepository.findAll(pageable);
    }

    @Override
    public BigTree getById(Long bigTreeId) {
        return bigTreeRepository.findById(bigTreeId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,bigTreeId));
    }

    @Override
    public BigTree create(BigTree bigTree) {
        Set<ConstraintViolation<BigTree>> violations = validator.validate(bigTree);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        BigTree bigTreeWithUsername = bigTreeRepository.findByUsername(bigTree.getUsername());

        if(bigTreeWithUsername != null)
            throw new ResourceValidationException(ENTITY,
                    "A BigTree with the same name already exists.");

        BigTree bigTreeWithEmail = bigTreeRepository.findByEmail(bigTree.getEmail());

        if(bigTreeWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A BigTree with the same email already exists.");

        return bigTreeRepository.save(bigTree);
    }

    @Override
    public BigTree update(Long bigTreeId, BigTree request) {
        Set<ConstraintViolation<BigTree>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        BigTree bigTreeWithUsername = bigTreeRepository.findByUsername(request.getUsername());

        if(bigTreeWithUsername != null && !bigTreeWithUsername.getId().equals(bigTreeId))
            throw new ResourceValidationException(ENTITY,
                    "A BigTree with the same name already exists.");

        BigTree bigTreeWithEmail = bigTreeRepository.findByEmail(request.getEmail());

        if(bigTreeWithEmail != null && !bigTreeWithEmail.getId().equals(bigTreeId))
            throw new ResourceValidationException(ENTITY,
                    "A BigTree with the same email already exists.");


        return bigTreeRepository.findById(bigTreeId).map(bigTree ->
                bigTreeRepository.save(
                        bigTree.withUsername(request.getUsername())
                                .withEmail(request.getEmail())
                                .withFirstName(request.getFirstName())
                                .withLastName(request.getLastName())
                                .withGender(request.getGender())
                                .withBornAt(request.getBornAt())
                )).orElseThrow(()->new ResourceNotFoundException(ENTITY,bigTreeId));

    }

    @Override
    public ResponseEntity<?> delete(Long bigTreeId) {
        return bigTreeRepository.findById(bigTreeId).map(bigTree -> {
            bigTreeRepository.delete(bigTree);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,bigTreeId));
    }
}

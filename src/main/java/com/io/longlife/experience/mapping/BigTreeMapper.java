package com.io.longlife.experience.mapping;

import com.io.longlife.experience.domain.model.entity.BigTree;
import com.io.longlife.experience.resource.BigTreeResource;
import com.io.longlife.experience.resource.CreateBigTreeResource;
import com.io.longlife.experience.resource.UpdateBigTreeResource;
import com.io.longlife.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BigTreeMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public BigTreeResource toResource(BigTree model){
        return mapper.map(model, BigTreeResource.class);
    }

    public BigTree toModel(CreateBigTreeResource resource){
        return mapper.map(resource,BigTree.class);
    }

    public BigTree toModel(UpdateBigTreeResource resource){
        return mapper.map(resource, BigTree.class);
    }

    public Page<BigTreeResource> modelListPage(List<BigTree> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,BigTreeResource.class),pageable,modelList.size());
    }
}

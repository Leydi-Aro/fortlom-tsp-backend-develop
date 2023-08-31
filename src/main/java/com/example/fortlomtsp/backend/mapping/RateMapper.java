package com.example.fortlomtsp.backend.mapping;
import com.example.fortlomtsp.backend.domain.model.entity.Rate;
import com.example.fortlomtsp.backend.resource.Rate.CreateRateResource;
import com.example.fortlomtsp.backend.resource.Rate.RateResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class RateMapper {



    @Autowired
    EnhancedModelMapper mapper;



    public RateResource toResource(Rate model) {
        return mapper.map(model, RateResource.class);
    }

    public Page<RateResource> modelListToPage(List<Rate> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RateResource.class), pageable, modelList.size());
    }
    public Rate toModel(CreateRateResource resource) {
        return mapper.map(resource, Rate.class);
    }

}

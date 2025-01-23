package com.bfit.jfsd.springboot.service;



import java.util.List;

import com.bfit.jfsd.springboot.model.Resource;

public interface ResourceService {
    Resource addResource(Resource resource);

    List<Resource> getAllResources();

    Resource getResourceById(Long id);

    void deleteResource(Long id);
}
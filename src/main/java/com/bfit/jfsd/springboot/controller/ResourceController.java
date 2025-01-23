package com.bfit.jfsd.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bfit.jfsd.springboot.model.Resource;
import com.bfit.jfsd.springboot.service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/nutritionist/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * Add a new resource
     */
    @PostMapping("/add")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.addResource(resource);
        return ResponseEntity.ok(createdResource);
    }

    /**
     * Get all resources
     */
    @GetMapping("/all")
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    /**
     * Get a resource by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Resource resource = resourceService.getResourceById(id);
        return ResponseEntity.ok(resource);
    }

    /**
     * Delete a resource by ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok("Resource deleted successfully with ID: " + id);
    }
}
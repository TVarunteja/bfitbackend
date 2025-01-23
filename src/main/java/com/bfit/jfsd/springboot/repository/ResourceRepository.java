package com.bfit.jfsd.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bfit.jfsd.springboot.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    // Additional query methods can be added here if needed
}
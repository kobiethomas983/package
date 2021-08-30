package com.example.demo.repository;

import com.example.demo.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Resource findByResourceId(String resourceId);
    List<Resource> findResourcesByDatasetIdAndFileType(String datasetId, String fileType);
    List<Resource> findResourcesByDatasetId(String datasetId);
}

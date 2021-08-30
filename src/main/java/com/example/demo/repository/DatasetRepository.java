package com.example.demo.repository;

import com.example.demo.model.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatasetRepository extends JpaRepository<Dataset, Long> {
    Dataset findByDatasetId(String datasetId);
    List<Dataset> findDatasetsByPackage(String packageId);
}

package com.example.demo.repository;

;
import com.example.demo.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SourceRepository extends JpaRepository<Source, Long> {
    Source findBySourceId(String sourceId);
    List<Source> findSourcesByDatasetIdAndFileType(String datasetId, String fileType);
    List<Source> findSourcesByDatasetId(String datasetId);
}

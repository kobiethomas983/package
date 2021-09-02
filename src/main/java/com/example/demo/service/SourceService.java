package com.example.demo.service;

import com.example.demo.exception.DataNotFoundException;
import com.example.demo.model.Source;
import com.example.demo.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SourceService {
    private final SourceRepository sourceRepository;

    @Autowired
    public SourceService(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    public Source createSource(Source source) {
        String sourceId = "Sr" + UUID.randomUUID();
        source.setSourceId(sourceId.substring(0,6));
        return sourceRepository.save(source);
    }

    public List<Source> getAllSourceForDataset(String datasetId) {
        return sourceRepository.findSourcesByDatasetId(datasetId);
    }

    public void deleteSourceById(String sourceId) {
        Source foundSource = sourceRepository
                .findBySourceId(sourceId);
        sourceRepository.delete(foundSource);
    }

    public Source getSourceById(String sourceId) {
        Source foundSource = sourceRepository
                .findBySourceId(sourceId);

        if (foundSource == null) {
            throw  new DataNotFoundException("Source doesn't exist with sourceId: " + sourceId);
        }
        return foundSource;
    }

    public Source updateSource(String sourceId, Source updatedSource) {
        Source existingSource = getSourceById(sourceId);

        if (updatedSource.getFileName() != null) {
            existingSource.setFileName(updatedSource.getFileName());
        }
        if (updatedSource.getFileSize() != null) {
            existingSource.setFileSize(updatedSource.getFileSize());
        }
        if (updatedSource.getFileType() != null) {
            existingSource.setFileType(updatedSource.getFileType());
        }
        return sourceRepository.save(existingSource);
    }
}

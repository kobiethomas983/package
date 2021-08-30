package com.example.demo.service;

import com.example.demo.exception.DataNotFoundException;
import com.example.demo.model.Dataset;
import com.example.demo.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DatasetService {
    private final DatasetRepository datasetRepository;

    @Autowired
    public DatasetService(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public Dataset createDataset(Dataset dataset) {
        String datasetId = "Ds" + UUID.randomUUID();
        dataset.setDatasetId(datasetId.substring(0,6));
        return datasetRepository.save(dataset);
    }

    public List<Dataset> getAll() {
        return datasetRepository.findAll();
    }

    public void deleteDatasetById(String datasetId) {
        Dataset foundDataset = datasetRepository
                .findByDatasetId(datasetId);

        datasetRepository.delete(foundDataset);
    }

    public Dataset getDatasetById(String datasetId) {
        Dataset foundDataset = datasetRepository
                .findByDatasetId(datasetId);

        if (foundDataset == null) {
            throw new DataNotFoundException("Dataset doesn't exist with datasetId: " + datasetId);
        }
        return datasetRepository.findByDatasetId(datasetId);
    }

    public List<Dataset> getDatasetByPackageId(String packageId) {
        return datasetRepository.findDatasetsByPackageId(packageId);
    }

}

package com.example.demo.service;

import com.example.demo.exception.DataNotFoundException;
import com.example.demo.model.Resource;
import com.example.demo.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource createResource(Resource resource) {
        String resourceId = "Rs" + UUID.randomUUID();
        resource.setResourceId(resourceId);
        return resourceRepository.save(resource);
    }

    public List<Resource> getAllResourceForDataset(String datasetId) {
        return resourceRepository.findResourcesByDatasetId(datasetId);
    }

    public void deleteResourceById(String resourceId) {
        Resource foundResource = resourceRepository
                .findByResourceId(resourceId);
        resourceRepository.delete(foundResource);
    }

    public Resource getResourceById(String resourceId) {
        Resource foundResource = resourceRepository
                .findByResourceId(resourceId);

        if (foundResource == null) {
            throw  new DataNotFoundException("Resource doesn't exist with resourceId: " + resourceId);
        }
        return foundResource;
    }

    public Resource updateResource(String resourceId, Resource updatedResource) {
        Resource existingResource = getResourceById(resourceId);

        if (updatedResource.getFileName() != null) {
            existingResource.setFileName(updatedResource.getFileName());
        }
        if (updatedResource.getFileSize() != null) {
            existingResource.setFileSize(updatedResource.getFileSize());
        }
        if (updatedResource.getFileType() != null) {
            existingResource.setFileType(updatedResource.getFileType());
        }
        return resourceRepository.save(existingResource);
    }
}

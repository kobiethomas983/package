package com.example.demo.controller;

import com.example.demo.model.Dataset;
import com.example.demo.model.Resource;
import com.example.demo.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resources")
@Api(value = "Resource Controller", tags = "Resource")
public class ResourceController {
    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    @ApiOperation(value = "Add a Resource", nickname = "saveDataset", tags = "Add Methods")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @GetMapping("/{resourceId}")
    @ApiOperation(value = "Get a list of Resources", nickname = "findResources", response = Resource.class, responseContainer = "List", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public Resource getResourceId(@PathVariable("resourceId") String resourceId) {
        return resourceService.getResourceById(resourceId);
    }

    @PutMapping("/{resourceId}")
    public Resource updateResource(@PathVariable("resourceId") String resourceId,
                                   @RequestBody Resource resource) {
        return resourceService.updateResource(resourceId, resource);
    }

    @DeleteMapping("/{resourceId}")
    @ApiOperation(value = "Delete resource by id", nickname = "deleteResourceById", tags = "Delete Methods")
    public void deleteResource(@PathVariable("resourceId") String resourceId) {
        resourceService.deleteResourceById(resourceId);
    }

    @GetMapping("/{datasetId}")
    public List<Resource> getAllResourcesForDataset(@PathVariable("datasetId") String datasetId) {
        return resourceService.getAllResourceForDataset(datasetId);
    }

}

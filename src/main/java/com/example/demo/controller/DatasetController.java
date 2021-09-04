package com.example.demo.controller;

import com.example.demo.model.Dataset;
import com.example.demo.service.DatasetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Dataset Controller", description = "Dataset Service API", tags = "Dataset")
public class DatasetController {
    private final DatasetService datasetService;

    @Autowired
    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @PostMapping("/datasets")
    @ApiOperation(value = "Add a Dataset", nickname = "saveDataset", tags = "Add Methods")
    public Dataset createDataset(@RequestBody Dataset dataset) {
        return datasetService.createDataset(dataset);
    }

    @GetMapping("/datasets")
    @ApiOperation(value = "Get a list of Datasets", nickname = "findDatasets", response = Dataset.class, responseContainer = "List", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public List<Dataset> getAll() {
        return datasetService.getAll();
    }

    @GetMapping("/datasets/{datasetId}")
    @ApiOperation(value = "Get Datasets by ids", nickname = "findDatasetById", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public Dataset getDatasetByDatasetId(@PathVariable("datasetId") String datasetId) {
        return datasetService.getDatasetById(datasetId);
    }

    @DeleteMapping("/datasets/{datasetId}")
    @ApiOperation(value = "Delete datasets by id", nickname = "deleteDatasetById", tags = "Delete Methods")
    public void deleteDatasetByDatasetId(@PathVariable("datasetId") String datasetId) {
        datasetService.deleteDatasetById(datasetId);
    }
}

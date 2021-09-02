package com.example.demo.controller;

import com.example.demo.model.Source;
import com.example.demo.service.SourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sources")
@Api(value = "Source Controller", tags = "Source")
public class SourceController {
    private final SourceService sourceService;

    @Autowired
    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @PostMapping
    @ApiOperation(value = "Add a Source", nickname = "saveDataset", tags = "Add Methods")
    public Source createSource(@RequestBody Source source) {
        return sourceService.createSource(source);
    }

    @GetMapping("/{sourceId}")
    @ApiOperation(value = "Get a list of Sources", nickname = "findSources", response = Source.class, responseContainer = "List", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public Source getSourceId(@PathVariable("sourceId") String sourceId) {
        return sourceService.getSourceById(sourceId);
    }

    @PutMapping("/{sourceId}")
    public Source updateSource(@PathVariable("sourceId") String sourceId,
                                   @RequestBody Source source) {
        return sourceService.updateSource(sourceId, source);
    }

    @DeleteMapping("/{sourceId}")
    @ApiOperation(value = "Delete source by id", nickname = "deleteSourceById", tags = "Delete Methods")
    public void deleteSource(@PathVariable("sourceId") String sourceId) {
        sourceService.deleteSourceById(sourceId);
    }

    @GetMapping("/{datasetId}")
    public List<Source> getAllSourcesForDataset(@PathVariable("datasetId") String datasetId) {
        return sourceService.getAllSourceForDataset(datasetId);
    }

}

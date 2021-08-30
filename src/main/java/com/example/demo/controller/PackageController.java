package com.example.demo.controller;

import com.example.demo.model.Dataset;
import com.example.demo.model.Package;
import com.example.demo.service.DatasetService;
import com.example.demo.service.PackageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Package Controller", description = "Package Service API", tags = "Package")
public class PackageController {
    private final PackageService packageService;
    private final DatasetService datasetService;

    @Autowired
    public PackageController(PackageService packageService,
                             DatasetService datasetService) {
        this.packageService = packageService;
        this.datasetService = datasetService;
    }

    @PostMapping("/package")
    @ApiOperation(value = "Add a Package", nickname = "savePackage", tags = "Add Methods")
    public Package createPackage(@RequestBody Package newPackage) {
        return packageService.createPackage(newPackage);
    }

    @GetMapping("/package")
    @ApiOperation(value = "Get a list of Packages", nickname = "findPackages", response = Package.class, responseContainer = "List", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public List<Package> getAll() {
        return packageService.getAll();
    }

    @DeleteMapping("/package/{packageId}")
    @ApiOperation(value = "Delete datasets by id", nickname = "deleteDatasetById", tags = "Delete Methods")
    public void deletePackageById(String packageId) {
        packageService.deletePackageById(packageId);
    }

    @GetMapping("/package/{packageId}")
    @ApiOperation(value = "Get Packages by ids", nickname = "findPackageById", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public Package getPackageById(String packageId) {
        return packageService.getPackageById(packageId);
    }

    @GetMapping("/package/{category}")
    public List<Package> getPackageByCategory(@PathVariable("category") String category) {
        return packageService.getPackageByCategory(category);
    }

    @GetMapping("/package/{country}")
    public List<Package> getPackageByCountry(@PathVariable("country") String country) {
        return packageService.getPackageByCountry(country);
    }

    @GetMapping("/package/datasets/{package}")
    public List<Dataset> getDatasetsMappedToPackage(@PathVariable("package") String packageId) {
        return datasetService.getDatasetByPackageId(packageId);
    }
}

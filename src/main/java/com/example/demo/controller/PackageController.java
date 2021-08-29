package com.example.demo.controller;

import com.example.demo.model.Dataset;
import com.example.demo.model.Package;
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

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
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

}

package com.example.demo.service;

import com.example.demo.exception.DataNotFoundException;
import com.example.demo.model.Package;
import com.example.demo.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PackageService {
    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public Package createPackage(Package newPackage) {
        String packageId = "Pk" + UUID.randomUUID();
        newPackage.setPackageId(packageId.substring(0,6));
        return packageRepository.save(newPackage);
    }

    public List<Package> getAll() {
        return packageRepository.findAll();
    }

    public void deletePackageById(String packageId) {
        Package foundPackage = packageRepository.findByPackageId(packageId);
        packageRepository.delete(foundPackage);
    }

    public Package getPackageById(String packageId) {
        Package foundPackage = packageRepository.findByPackageId(packageId);
        if (foundPackage == null) {
            throw new DataNotFoundException("Package doesn't exist with id: "+ packageId);
        }
        return foundPackage;
    }

    public List<Package> getPackageByCategory(String category) {
        return packageRepository.findPackageByCategory(category);
    }

    public List<Package> getPackageByCountry(String country) {
        return packageRepository.findPackageByCountry(country);
    }
}

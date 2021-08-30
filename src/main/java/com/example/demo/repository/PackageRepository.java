package com.example.demo.repository;

import com.example.demo.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, Long> {
    Package findByPackageId(String packageId);
    List<Package> findPackageByCategory(String category);
    List<Package> findPackageByCountry(String country);
}

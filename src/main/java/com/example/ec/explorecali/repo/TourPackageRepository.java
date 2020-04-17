package com.example.ec.explorecali.repo;

import com.example.ec.explorecali.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(String name);
}

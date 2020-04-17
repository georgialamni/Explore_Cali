package com.example.ec.explorecali.services;

import com.example.ec.explorecali.domain.TourPackage;
import com.example.ec.explorecali.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a Tour Package
     *
     * @param code of the package
     * @param name of the package
     * @return new or existing tour package
     */
    public TourPackage createTourPackage(String code, String name) {

        return tourPackageRepository.findById(code).orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    /**
     * Lookup All Tour Package
     *
     * @return all tour package
     */
    public Iterable<TourPackage> lookup() {

        return tourPackageRepository.findAll();
    }

    public long total() {
        return tourPackageRepository.count();
    }
}

package com.example.ec.explorecali.services;

import com.example.ec.explorecali.domain.Difficulty;
import com.example.ec.explorecali.domain.Region;
import com.example.ec.explorecali.domain.Tour;
import com.example.ec.explorecali.domain.TourPackage;
import com.example.ec.explorecali.repo.TourPackageRepository;
import com.example.ec.explorecali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour Object and persist it on the Database
     *
     * @param title           title
     * @param description     description
     * @param blurb           blurb
     * @param price           price
     * @param duration        duration
     * @param bullets         comma-separated bullets
     * @param keywords        keywords
     * @param tourPackageName tour package name
     * @param difficulty      difficulty
     * @param region          region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets, String keywords, String tourPackageName,
                           Difficulty difficulty, Region region) {

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if (tourPackage == null) {
            throw new RuntimeException("Tour package does not exists." + tourPackageName);
        }

        return tourRepository.save(new Tour(title, description, blurb, price,
                duration, bullets, keywords, tourPackage, difficulty, region));

    }

    /**
     * Calculate the number of Tours in the Database
     *
     * @return the total
     */
    public long total() {
        return tourRepository.count();
    }
}

package com.example.ec.explorecali.repo;

import com.example.ec.explorecali.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    /**
     * Find Tours associated with the Tour Package
     *
     * @param code tour package code
     * @return List of found tours
     */
    Page<Tour> findByTourPackageCode(String code, Pageable pageable);
}

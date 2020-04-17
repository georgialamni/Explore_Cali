package com.example.ec.explorecali.repo;

import com.example.ec.explorecali.domain.TourRating;
import com.example.ec.explorecali.domain.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

    /**
     * Lookup all the TourRatings for a tour
     *
     * @param tourId is the tour Identifier
     * @return a list of any found TourRatings
     */
    List<TourRating> findByPkTourId(Integer tourId);

    /**
     *Lookup a TourRatings by the TourId and CustomerId
     * @param tourId tour identifier
     * @param customerId customer identifier
     * @return Optional of found TourRatings
     */
    Optional<TourRating> findByPkTourIdAndPkCustomer(Integer tourId, Integer customerId);
}

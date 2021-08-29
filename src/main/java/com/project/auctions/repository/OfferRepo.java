package com.project.auctions.repository;

import com.project.auctions.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepo extends CrudRepository<Offer,Long> {
    void deleteById(Long id);

    Optional<Offer> findById(Long id);
}

package com.project.auctions.repository;

import com.project.auctions.domain.Auction;
import com.project.auctions.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepo extends CrudRepository<Offer,Long> {
    void deleteById(Long id);

    Optional<Offer> findById(Long id);

    @Query(value ="SELECT * FROM auction.offers where seller_id = :ARG",nativeQuery = true)
    List<Offer> findOfferByUserId(@Param("ARG") Long arg);
}

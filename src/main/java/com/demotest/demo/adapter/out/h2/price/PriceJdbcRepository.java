package com.demotest.demo.adapter.out.h2.price;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceJdbcRepository extends CrudRepository<PriceDomain, Integer> {

    @Query("""
        SELECT * FROM PRICES
        WHERE START_DATE <= :date
        AND END_DATE >= :date
        AND PRODUCT_ID = :productId
        AND BRAND_ID = :brandId
        AND PRIORITY = (select max(PRIORITY) from PRICES WHERE START_DATE <= :date
        AND END_DATE >= :date
        AND PRODUCT_ID = :productId
        AND BRAND_ID = :brandId)
    """)
    Optional<PriceDomain> findPriceDomain(@Param("date") LocalDateTime date, @Param("productId")Integer productId, @Param("brandId")Integer brandId);
}

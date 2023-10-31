package com.demotest.demo.adapter.out.h2.price;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("PRICES")
public class PriceDomain {
    @Id
    @Column("ID")
    private Integer id;
    @Column("BRAND_ID")
    private Integer brandId;
    @Column("START_DATE")
    private LocalDateTime startDate;
    @Column("END_DATE")
    private LocalDateTime endDate;
    @Column("PRICE_LIST")
    private Integer priceList;
    @Column("PRODUCT_ID")
    private Integer productId;
    @Column("PRIORITY")
    private Integer priority;
    @Column("PRICE")
    private Double price;
    @Column("CURR")
    private String currency;
}

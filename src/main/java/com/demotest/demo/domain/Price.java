package com.demotest.demo.domain;

import java.time.LocalDateTime;

public record Price(

        Integer brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer priceList,
        Integer productId,
        Integer priority,
        Double price,
        String currency
) {
}

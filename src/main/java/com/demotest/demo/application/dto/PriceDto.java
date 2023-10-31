package com.demotest.demo.application.dto;

import java.time.LocalDateTime;

public record PriceDto(
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

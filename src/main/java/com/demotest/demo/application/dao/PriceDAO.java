package com.demotest.demo.application.dao;

import com.demotest.demo.application.dto.PriceDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceDAO {
    List<PriceDto> getPrices();
    PriceDto getPrice(String startDate, Integer productId, String stringIdentifier);
}

package com.demotest.demo.adapter.out.h2.price;

import com.demotest.demo.application.dao.PriceDAO;
import com.demotest.demo.application.dto.PriceDto;
import com.demotest.demo.infrastructure.exceptions.errors.PriceNotFoundException;
import com.demotest.demo.infrastructure.exceptions.handlers.ErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class PriceJdbcRepositoryAdapter implements PriceDAO {
    private final PriceJdbcRepository priceJdbcRepository;
    @Override
    public List<PriceDto> getPrices() {
          return ((List<PriceDomain>) priceJdbcRepository.findAll())
                 .stream()
                 .map(priceDomain -> new PriceDto(
                         priceDomain.getBrandId(),
                         priceDomain.getStartDate(),
                         priceDomain.getEndDate(),
                         priceDomain.getPriceList(),
                         priceDomain.getProductId(),
                         priceDomain.getPriority(),
                         priceDomain.getPrice(),
                         priceDomain.getCurrency()

                 )).toList();
    }

    @Override
    public PriceDto getPrice(String startDateString, Integer productId, String stringIdentifier) {
        int brandId =  0;
        if(stringIdentifier.equalsIgnoreCase("ZARA")) brandId = 1;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(startDateString, formatter);

        log.info("Brand is {} and date is {}", brandId, startDate);
        var priceDomain = priceJdbcRepository.findPriceDomain(startDate, productId, brandId)
                .orElseThrow(() -> new PriceNotFoundException(ErrorMessages.PRICE_NOT_FOUND_ERROR));
                 return  new PriceDto(
                        priceDomain.getBrandId(),
                        priceDomain.getStartDate(),
                        priceDomain.getEndDate(),
                        priceDomain.getPriceList(),
                        priceDomain.getProductId(),
                        priceDomain.getPriority(),
                        priceDomain.getPrice(),
                        priceDomain.getCurrency()

                );
    }

}

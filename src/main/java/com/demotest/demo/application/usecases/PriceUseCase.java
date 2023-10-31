package com.demotest.demo.application.usecases;

import com.demotest.demo.application.dao.PriceDAO;
import com.demotest.demo.application.dto.PriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceUseCase {
    private final PriceDAO priceDAO;

    public List<PriceDto> getPrices(){
        return priceDAO.getPrices();
    }

    public PriceDto getPrice(String startDate, Integer productId, String stringIdentifier) {
        return priceDAO.getPrice(startDate, productId, stringIdentifier);
    }
}

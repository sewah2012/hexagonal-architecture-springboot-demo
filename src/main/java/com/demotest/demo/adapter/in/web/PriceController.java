package com.demotest.demo.adapter.in.web;

import com.demotest.demo.application.usecases.PriceUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@Slf4j
@RequiredArgsConstructor
public class PriceController {
    private final PriceUseCase priceUseCase;

    @GetMapping
    ResponseEntity<?> getAllPrices() {
        return ResponseEntity.ok(priceUseCase.getPrices());
    }


    @GetMapping("/params")
    ResponseEntity<?> getPrice(
            @RequestParam("date")String startDate,
            @RequestParam("productId") Integer productId,
            @RequestParam("stringIdentifier") String stringIdentifier
            ) {
        return ResponseEntity.ok(priceUseCase.getPrice(startDate, productId, stringIdentifier));
    }


}

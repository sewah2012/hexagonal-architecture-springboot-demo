package com.demotest.demo.adapter.in.web;

import com.demotest.demo.application.dto.PriceDto;
import com.demotest.demo.application.usecases.PriceUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceUseCase priceUseCase;

    @BeforeEach
    void setup() {
        // Define any necessary setup before each test
    }

    @Test
    public void testGetAllPrices() throws Exception {

        // Define the behavior of the priceUseCase when getPrices is called
        when(priceUseCase.getPrices()).thenReturn(new ArrayList<>());

        // Perform the GET request to the /prices endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testGetPrice() throws Exception {
        var priceDto = new PriceDto(
                1,
                LocalDateTime.of(2020,6,15,0,0),
                LocalDateTime.of(2020,6,15,11,0),
                3,
                35455,
                1,
                30.5d,
                "EUR"
        );
        // Define the behavior of the priceUseCase when getPrice is called with specific parameters
        when(priceUseCase.getPrice(any(), any(), any())).thenReturn(priceDto);

        // Perform the GET request to the /prices/params endpoint with query parameters
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/params")
                        .param("date", "2023-10-28")
                        .param("productId", "123")
                        .param("stringIdentifier", "example")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                                .string("""
                                        {"brandId":1,"startDate":"2020-06-15T00:00:00","endDate":"2020-06-15T11:00:00","priceList":3,"productId":35455,"priority":1,"price":30.5,"currency":"EUR"}"""));
    }
}
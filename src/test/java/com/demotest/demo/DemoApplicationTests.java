package com.demotest.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetPrice1() throws Exception {
		var uri = "/prices/params?date=2020-06-14-10:00:00&productId=35455&stringIdentifier=zara";

		mockMvc.perform(
						get(uri)
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(
						content().json("""
						{
						  "brandId": 1,
						  "startDate": "2020-06-14T00:00:00",
						  "endDate": "2020-12-31T23:59:59",
						  "priceList": 1,
						  "productId": 35455,
						  "priority": 0,
						  "price": 35.5,
						  "currency": "EUR"
						}
						""")
				);

	}

	@Test
	void testGetPrice2() throws Exception {
		var uri = "/prices/params?date=2020-06-14-16:00:00&productId=35455&stringIdentifier=zara";

		mockMvc.perform(
						get(uri)
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(
						content().json("""
						{
						  "brandId": 1,
						  "startDate": "2020-06-14T15:00:00",
						  "endDate": "2020-06-14T18:30:00",
						  "priceList": 2,
						  "productId": 35455,
						  "priority": 1,
						  "price": 25.45,
						  "currency": "EUR"
						}
						""")
				);

	}

	@Test
	void testGetPrice3() throws Exception {
		var uri = "/prices/params?date=2020-06-14-21:00:00&productId=35455&stringIdentifier=zara";

		mockMvc.perform(
						get(uri)
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(
						content().json("""
						{
						  "brandId": 1,
						  "startDate": "2020-06-14T00:00:00",
						  "endDate": "2020-12-31T23:59:59",
						  "priceList": 1,
						  "productId": 35455,
						  "priority": 0,
						  "price": 35.5,
						  "currency": "EUR"
						}
						""")
				);

	}

	@Test
	void testGetPrice4() throws Exception {
		var uri = "/prices/params?date=2020-06-15-10:00:00&productId=35455&stringIdentifier=zara";

		mockMvc.perform(
				get(uri)
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(
						content().json("""
						{
							"brandId": 1,
							"startDate": "2020-06-15T00:00:00",
							"endDate": "2020-06-15T11:00:00",
							"priceList": 3,
							"productId": 35455,
							"priority": 1,
							"price": 30.5,
							"currency": "EUR"
						}
						""")
				);

	}

	@Test
	void testGetPrice5() throws Exception {
		var uri = "/prices/params?date=2020-06-16-21:00:00&productId=35455&stringIdentifier=zara";

		mockMvc.perform(
						get(uri)
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(
						content().json("""
						{
							  "brandId": 1,
							  "startDate": "2020-06-15T16:00:00",
							  "endDate": "2020-12-31T23:59:59",
							  "priceList": 4,
							  "productId": 35455,
							  "priority": 1,
							  "price": 38.95,
							  "currency": "EUR"
						  }
						""")
				);

	}

	@Test
	void contextLoads() {
	}
}

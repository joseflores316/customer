package com.cronos.customer.infraestructure.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIntegrationTest {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();

    }

    @Test
    @Order(1)
    void getCustomers() throws JsonProcessingException {
        ResponseEntity<String> response = client.getForEntity("/api/customer", String.class);

        String json = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());



        JsonNode jsonNode = objectMapper.readTree(json);

        assertTrue(json.contains("{\"id\":2,\"name\":\"pau\",\"surname\":\"aylas\""));

        assertEquals(2, jsonNode.size());

        assertEquals("pau", jsonNode.get(1).get("name").asText());
        assertEquals("aylas", jsonNode.get(1).get("surname").asText());

    }
}
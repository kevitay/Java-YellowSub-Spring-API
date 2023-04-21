package com.galvanize.yellowsub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class YellowSubControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllSandwiches() throws Exception {
        mockMvc.perform(get("/api/sandwich"))
                .andDo(print())
                .andExpect(jsonPath("$",hasSize(0)));
    }

    @Test
    public void addSandwichWithSampleData() throws Exception {
        String sandwichJson = "{\n" +
                "  \"bread\": \"white\",\n" +
                "  \"veggies\": [\n" +
                "    \"lettuce\",\n" +
                "    \"tomato\"\n" +
                "  ],\n" +
                "  \"meats\": [\n" +
                "    \"ham\",\n" +
                "    \"turkey\"\n" +
                "  ],\n" +
                "  \"condiments\": [\n" +
                "    \"mayo\"\n" +
                "  ]\n" +
                "}";
        mockMvc.perform(post("/api/sandwich")
                        .contentType(MediaType.APPLICATION_JSON).content(sandwichJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.bread").value("white"))
                .andExpect(jsonPath("$.veggies[0]").value("lettuce"))
                .andExpect(jsonPath("$.veggies[1]").value("tomato"))
                .andExpect(jsonPath("$.meats[0]").value("ham"))
                .andExpect(jsonPath("$.meats[1]").value("turkey"))
                .andExpect(jsonPath("$.condiments[0]").value("mayo"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/sandwich"))
                .andDo(print())
                .andExpect(jsonPath("$[0].bread").value("white"))
                .andExpect(jsonPath("$[0].veggies[0]").value("lettuce"))
                .andExpect(jsonPath("$[0].veggies[1]").value("tomato"))
                .andExpect(jsonPath("$[0].meats[0]").value("ham"))
                .andExpect(jsonPath("$[0].meats[1]").value("turkey"))
                .andExpect(jsonPath("$[0].condiments[0]").value("mayo"));
    }
//    Given I have the example JSON without an "orderNumber"
//    When I "POST /api/sandwich"
//    Then the returned JSON should have an "orderNumber" that is a UUID.
@Test
public void addSandwichWithNoOrderNo() throws Exception {
    String sandwichJson = "{\n" +
            "  \"bread\": \"white\",\n" +
            "  \"veggies\": [\n" +
            "    \"lettuce\",\n" +
            "    \"tomato\"\n" +
            "  ],\n" +
            "  \"meats\": [\n" +
            "    \"ham\",\n" +
            "    \"turkey\"\n" +
            "  ],\n" +
            "  \"condiments\": [\n" +
            "    \"mayo\"\n" +
            "  ]\n" +
            "}";
    mockMvc.perform(post("/api/sandwich")
                    .contentType(MediaType.APPLICATION_JSON).content(sandwichJson))
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.orderNumber").isNotEmpty())
            .andExpect(jsonPath("$.bread").value("white"))
            .andExpect(jsonPath("$.veggies[0]").value("lettuce"))
            .andExpect(jsonPath("$.veggies[1]").value("tomato"))
            .andExpect(jsonPath("$.meats[0]").value("ham"))
            .andExpect(jsonPath("$.meats[1]").value("turkey"))
            .andExpect(jsonPath("$.condiments[0]").value("mayo"));

    mockMvc.perform(MockMvcRequestBuilders.get("/api/sandwich"))
            .andDo(print())
            .andExpect(jsonPath("$[0].orderNumber").isNotEmpty())
            .andExpect(jsonPath("$[0].bread").value("white"))
            .andExpect(jsonPath("$[0].veggies[0]").value("lettuce"))
            .andExpect(jsonPath("$[0].veggies[1]").value("tomato"))
            .andExpect(jsonPath("$[0].meats[0]").value("ham"))
            .andExpect(jsonPath("$[0].meats[1]").value("turkey"))
            .andExpect(jsonPath("$[0].condiments[0]").value("mayo"));
    }

    @Test
    public void canReceiveSandwichWithOrderNumber() throws Exception {
        String sandwichJson = "{\n" +
                "  \"orderNumber\": \"53cd99f1-9dab-4dae-86e1-f4bdc90fe3a4\",\n" +
                "  \"bread\": \"white\",\n" +
                "  \"veggies\": [\n" +
                "    \"lettuce\",\n" +
                "    \"tomato\"\n" +
                "  ],\n" +
                "  \"meats\": [\n" +
                "    \"ham\",\n" +
                "    \"turkey\"\n" +
                "  ],\n" +
                "  \"condiments\": [\n" +
                "    \"mayo\"\n" +
                "  ]\n" +
                "}";
        mockMvc.perform(post("/api/sandwich")
                        .contentType(MediaType.APPLICATION_JSON).content(sandwichJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.orderNumber").value("53cd99f1-9dab-4dae-86e1-f4bdc90fe3a4"))
                .andExpect(jsonPath("$.bread").value("white"))
                .andExpect(jsonPath("$.veggies[0]").value("lettuce"))
                .andExpect(jsonPath("$.veggies[1]").value("tomato"))
                .andExpect(jsonPath("$.meats[0]").value("ham"))
                .andExpect(jsonPath("$.meats[1]").value("turkey"))
                .andExpect(jsonPath("$.condiments[0]").value("mayo"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/sandwich/53cd99f1-9dab-4dae-86e1-f4bdc90fe3a4"))
                .andDo(print())
                .andExpect(jsonPath("$.orderNumber").value("53cd99f1-9dab-4dae-86e1-f4bdc90fe3a4"))
                .andExpect(jsonPath("$.bread").value("white"))
                .andExpect(jsonPath("$.veggies[0]").value("lettuce"))
                .andExpect(jsonPath("$.veggies[1]").value("tomato"))
                .andExpect(jsonPath("$.meats[0]").value("ham"))
                .andExpect(jsonPath("$.meats[1]").value("turkey"))
                .andExpect(jsonPath("$.condiments[0]").value("mayo"));
    }


}

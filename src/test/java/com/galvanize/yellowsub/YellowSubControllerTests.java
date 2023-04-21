package com.galvanize.yellowsub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andExpect(jsonPath("$.bread").value("white"));

    }
}

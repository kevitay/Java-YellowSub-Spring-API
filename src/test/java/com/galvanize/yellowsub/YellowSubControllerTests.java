package com.galvanize.yellowsub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
}

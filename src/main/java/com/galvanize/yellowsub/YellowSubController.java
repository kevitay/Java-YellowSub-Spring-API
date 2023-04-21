package com.galvanize.yellowsub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sandwich")
public class YellowSubController {
    public List<Sandwich> sandwiches = new ArrayList<>();


    @GetMapping("")
    public List<Sandwich> getAllSandwiches() {
        return sandwiches;
    }


}


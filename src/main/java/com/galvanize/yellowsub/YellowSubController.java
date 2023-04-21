package com.galvanize.yellowsub;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public ResponseEntity<Sandwich> addNewSandwich(@RequestBody Sandwich sandwich) {
        sandwiches.add(sandwich);
        return new ResponseEntity<Sandwich>(sandwich, HttpStatus.CREATED);
    }

}


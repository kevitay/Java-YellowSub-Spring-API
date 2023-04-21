package com.galvanize.yellowsub;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sandwich")
public class YellowSubController {
    public List<Sandwich> sandwiches = new ArrayList<>();


    @GetMapping("")
    public List<Sandwich> getAllSandwiches() {
        return sandwiches;
    }

    @GetMapping("/{orderNumber}")
    public Sandwich getOrderInfo(@PathVariable UUID orderNumber) {
        Sandwich orderedSandwich = null;
        for (Sandwich sandwich : sandwiches) {
            if (sandwich.getOrderNumber().equals(orderNumber)) {
                orderedSandwich = sandwich;
            }
        }
        return orderedSandwich;
    }

    @PostMapping("")
    public ResponseEntity<Sandwich> addNewSandwich(@RequestBody Sandwich sandwich) {
        sandwiches.add(sandwich);
        return new ResponseEntity<Sandwich>(sandwich, HttpStatus.CREATED);
    }

    @DeleteMapping("/reset")
    public List<Sandwich> resetList() {
        //clear the list
        sandwiches.clear();
        return sandwiches;
    }

}


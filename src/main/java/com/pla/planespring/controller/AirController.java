package com.pla.planespring.controller;


import com.pla.planespring.pojo.AirCalculator;
import com.pla.planespring.pojo.Travaler;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirController {

    @PostMapping("/result")
    public String getresult(@RequestBody Travaler travaler){
        System.out.println("receive");
        Float result = AirCalculator.calculator(travaler.getListLugs(),travaler.isInternal(),travaler.getSeatType(),travaler.getTrav_type(),travaler.getFlight());

        return result.toString();
    }
}

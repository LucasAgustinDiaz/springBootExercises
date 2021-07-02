package com.example.demo.controllers;

import com.example.demo.models.CodigoMorse;
import com.example.demo.models.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class CodigoMorseController {

    @GetMapping("/parserMorse")
    public CodigoMorse casting(@RequestParam(value="morseCode",required = true) String c){
//        NumeroRomano n = new NumeroRomano(number);
        return new CodigoMorse(c,1);
    }

    @GetMapping("/parserToMorse")
    public CodigoMorse castingToMorse(@RequestParam(value="languageNatural",required = true) String c){
//        NumeroRomano n = new NumeroRomano(number);
        return new CodigoMorse(c,2);
    }

}

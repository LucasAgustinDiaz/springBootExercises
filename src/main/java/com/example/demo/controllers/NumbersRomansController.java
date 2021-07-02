package com.example.demo.controllers;

import com.example.demo.models.NumeroRomano;
import com.example.demo.models.NumeroRomanoBadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// ejecuta o define los endpoitns
@RestController
@RequestMapping("/romans")
public class NumbersRomansController {
    private final AtomicLong counter = new AtomicLong();

    /**
     *
     * @param number
     * @return ResponseEntity<NumeroRomano>
     */
    @GetMapping("/castingDecimal")
    public ResponseEntity casting(@RequestParam(value="number",required = true) Integer number){
        return new ResponseEntity<>( new NumeroRomano(number),HttpStatus.OK);
    }


    /**
     *
     * @param number
     * @return ResponseEntity<NumeroRomano> OR ResponseEntity<NumeroRomanoBadRequest>
     */
    @GetMapping("/castingRomano")
    public ResponseEntity casting(@RequestParam(value="number",required = true) String number){
        AtomicBoolean found = new AtomicBoolean(false);
        NumeroRomano.getRomansNumbers().forEach((el) -> {
            if (el.equals(number))
                found.set(true);
        });
        return found.get()? new ResponseEntity<>( new NumeroRomano(number),HttpStatus.OK) : new ResponseEntity(new NumeroRomanoBadRequest(),HttpStatus.BAD_REQUEST);
    }


}



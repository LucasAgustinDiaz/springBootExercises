package com.example.demo.controllers;

import com.example.demo.models.CodigoMorse;
import com.example.demo.models.NumeroRomano;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class CodigoMorseController {

    /**
     *
     * @param msj String
     * @return ResponseEntity<ResponseEntity>
     */
    @GetMapping("/parserMorse")
    public ResponseEntity<CodigoMorse> casting(@RequestParam(value="morseCode",required = true) String msj){
        return new ResponseEntity<CodigoMorse>( new CodigoMorse(msj,1), HttpStatus.OK);
    }

    /**
     *
     * @param msj String
     * @return ResponseEntity<ResponseEntity>
     */
    @GetMapping("/parserToMorse")
    public ResponseEntity<CodigoMorse> castingToMorse(@RequestParam(value="languageNatural",required = true) String msj){
//        NumeroRomano n = new NumeroRomano(number);
        return new ResponseEntity<CodigoMorse>( new CodigoMorse(msj,2), HttpStatus.OK);

    }

}

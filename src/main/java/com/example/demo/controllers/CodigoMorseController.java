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
     * Translate morse code to natural language
     * @param msj String
     * @return ResponseEntity<ResponseEntity>
     */
    @GetMapping("/translateToNaturalLanguage")
    public ResponseEntity<CodigoMorse> casting(@RequestParam(value="morseCode",required = true) String msj){
        return new ResponseEntity<CodigoMorse>( new CodigoMorse(msj,1), HttpStatus.OK);
    }

    /**
     * Translate natural language to morse code
     * @param msj String
     * @return ResponseEntity<ResponseEntity>
     */
    @GetMapping("/traslateToMorse")
    public ResponseEntity<CodigoMorse> castingToMorse(@RequestParam(value="languageNatural",required = true) String msj){
//        NumeroRomano n = new NumeroRomano(number);
        return new ResponseEntity<CodigoMorse>( new CodigoMorse(msj,2), HttpStatus.OK);

    }

}

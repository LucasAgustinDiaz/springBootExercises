package com.example.demo.models;

import com.example.demo.response.ResponseNumeroRomano;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
public class NumeroRomano {
    HashMap<Integer, String> romanLetterParser = new HashMap();;
    private Integer wholeNumber;
    private String romanNumber;

    /**
     *
     * @param decimal  Whole number to roman number
     */
    public NumeroRomano(Integer decimal) {
        this.loadLetterParser();
        this.wholeNumber = decimal;
        this.romanNumber = this.numberToRoman(decimal);
    }

    /**
     *
     * @param romanNumber Roman number to whole number
     */
    public NumeroRomano(String romanNumber) {
        this.loadLetterParser();
        this.wholeNumber = this.castingRomToDec(romanNumber);
        this.romanNumber = romanNumber;
    }

    // LETTERS PARSERS  =================================================
    public void loadLetterParser(){
        romanLetterParser.put(1,"I");
        romanLetterParser.put(2,"II");
        romanLetterParser.put(3,"III");
        romanLetterParser.put(5,"V");
        romanLetterParser.put(6,"VI");
        romanLetterParser.put(7,"VII");
        romanLetterParser.put(8,"VIII");
        romanLetterParser.put(8,"IX");
        romanLetterParser.put(10,"X");
        romanLetterParser.put(11,"XI");
        romanLetterParser.put(12,"XII");
        romanLetterParser.put(13,"XIII");
        romanLetterParser.put(14,"XIV");
        romanLetterParser.put(15,"XV");
        romanLetterParser.put(16,"XVI");
        romanLetterParser.put(17,"XVII");
        romanLetterParser.put(18,"XVIII");
        romanLetterParser.put(19,"XIX");
        romanLetterParser.put(20,"XX");

    }
    // END LETTERS PARSERS  =================================================

    // FUNCTION =================================================
    // replace to numberToRoman function
    private String castingDecToRom(Integer i) {
        return this.romanLetterParser.get(i);
    }

    // Whole Number to Roman number
    private String numberToRoman(int numero) {
        int i, miles, centenas, decenas, unidades;
        String romano = "";
        //obtenemos cada cifra del número
        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        //millar
        for (i = 1; i <= miles; i++) {
            romano = romano + "M";
        }

        //centenas
        if (centenas == 9) {
            romano = romano + "CM";
        } else if (centenas >= 5) {
            romano = romano + "D";
            for (i = 6; i <= centenas; i++) {
                romano = romano + "C";
            }
        } else if (centenas == 4) {
            romano = romano + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romano = romano + "C";
            }
        }

        //decenas
        if (decenas == 9) {
            romano = romano + "XC";
        } else if (decenas >= 5) {
            romano = romano + "L";
            for (i = 6; i <= decenas; i++) {
                romano = romano + "X";
            }
        } else if (decenas == 4) {
            romano = romano + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano = romano + "X";
            }
        }

        //unidades
        if (unidades == 9) {
            romano = romano + "IX";
        } else if (unidades >= 5) {
            romano = romano + "V";
            for (i = 6; i <= unidades; i++) {
                romano = romano + "I";
            }
        } else if (unidades == 4) {
            romano = romano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano = romano + "I";
            }
        }
        return romano;

    } // Function extract to Internet

    // Roman number to whole number
    public Integer castingRomToDec(String i) {
        Integer numero = 0;

        for (Map.Entry<Integer, String> entry : this.romanLetterParser.entrySet()) {
            if (entry.getValue().equals(i)){
                numero = entry.getKey();
                System.out.println(numero);
            }
        }

        return numero;
    }

    // END FUNCTION =================================================
    // GETTERS AND SETTERS =================================================

    public Integer getWholeNumber() {
        return wholeNumber;
    }

    public void setWholeNumber(Integer wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public void setRomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }


    // END GETTERS AND SETTERS =================================================

    public static ArrayList<String> getRomansNumbers(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("I");
        lista.add("II");
        lista.add("III");
        lista.add("IV");
        lista.add("V");
        lista.add("VI");
        lista.add("VII");
        lista.add("VIII");
        lista.add("IX");
        lista.add("X");
        lista.add("XI");
        lista.add("XII");
        lista.add("XIII");
        lista.add("XIV");
        lista.add("XV");
        lista.add("XVI");
        lista.add("XVII");
        lista.add("XVIII");
        lista.add("XIV");
        lista.add("XX");
        return lista;
    }
}

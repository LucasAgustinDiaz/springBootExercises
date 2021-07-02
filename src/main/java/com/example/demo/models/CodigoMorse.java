package com.example.demo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CodigoMorse {
    private HashMap<String, String> morseLetterParser = new HashMap<String, String>();
    private String morseCode;
    private String languageNatural;
    private String action;


    // variables / lenguaje natural to morse -------
    private String chainToMorse = "";
    private String morsePrepare = "";

    // variables / morse to lenguage natural -------
    private String chainToNatural = "";
    private String naturalPrepare = "";


    /**
     * constructor method
     * @param msj message to translate
     * @param action  --- 1 morse to natural || 2 natural to morse
     */
    public CodigoMorse(String msj,int action) {
        this.loadMorseLetterParser();
        if (action == 1) {
            this.morseCode = msj;
            this.languageNatural = this.traductionToNatural(msj);
            this.action = "Morse code to natural language";
        } else {
            this.languageNatural = msj;
            this.morseCode = this.prepareMsjToMorse(msj);
            this.action = "Natural language to morse code";
        }
    }


    // LETTERS PARSERS ==================================================

    public void loadMorseLetterParser(){
        morseLetterParser.put(".-", "A");
        morseLetterParser.put("-...", "B");
        morseLetterParser.put("-.-.", "C");
        morseLetterParser.put("-..", "D");
        morseLetterParser.put(".", "E");
        morseLetterParser.put("..-.", "F");
        morseLetterParser.put("--.", "G");
        morseLetterParser.put("....", "H");
        morseLetterParser.put("..", "I");
        morseLetterParser.put(".---", "J");
        morseLetterParser.put("-.-", "K");
        morseLetterParser.put(".-..", "L");
        morseLetterParser.put("--", "M");
        morseLetterParser.put("-.", "N");
        morseLetterParser.put("---", "O");
        morseLetterParser.put(".--.", "P");
        morseLetterParser.put("--.-", "Q");
        morseLetterParser.put(".-.", "R");
        morseLetterParser.put("...", "S");
        morseLetterParser.put("-", "T");
        morseLetterParser.put("..-", "U");
        morseLetterParser.put("...-", "V");
        morseLetterParser.put(".--", "W");
        morseLetterParser.put("-..-", "X");
        morseLetterParser.put("-.--", "Y");
        morseLetterParser.put("--..", "Z");
        morseLetterParser.put(".----", "1");
        morseLetterParser.put("..---", "2");
        morseLetterParser.put("...--", "3");
        morseLetterParser.put("....-", "4");
        morseLetterParser.put(".....", "5");
        morseLetterParser.put("-....", "6");
        morseLetterParser.put("--...", "7");
        morseLetterParser.put("---..", "8");
        morseLetterParser.put("----.", "9");
        morseLetterParser.put("-----", "0");
        morseLetterParser.put(" ", "");
        morseLetterParser.put("", " ");
    }

    // END LETTERS PARSERS ==================================================

    // MORSE TO NATURAL ==================================================

    // This function processes each word separately
    public String traductionToNatural(String m) {
        String[] substrs = m.split("   ");
        for (int i = 0; i <substrs.length ; i++) {
            System.out.println(substrs[i]);
            naturalPrepare += translationToNatural(substrs[i]);
        }
        return naturalPrepare.trim();
    }

    // This function translates a word to natural language
    public String translationToNatural(String chain){
        String[] substr = chain.split(" ");
        chainToNatural = "";
        for (int i = 0; i < substr.length ; i++) {
            chainToNatural += this.matcherMorseToLeng(substr[i]);
        }
        return chainToNatural+" ";
    }

    // This function matches an element of natural language
    public String matcherMorseToLeng(String key){
        return this.morseLetterParser.get(key);
    }

    // END MORSE TO NATURAL ==================================================

    // NATURAL TO MORSE ==================================================

    // This function processes each word separately
    public String prepareMsjToMorse(String m){
        String[] substrs = m.split(" ");
        for (int i = 0; i <substrs.length ; i++) {
            morsePrepare += translationToMorse(substrs[i]);
        }
        return morsePrepare.trim();
    }
    // This function translates a word to morse code
    public String translationToMorse(String chain){
        String[] substr = chain.toUpperCase(Locale.ROOT).split("");
        chainToMorse = "";
        for (int i = 0; i <substr.length ; i++) { // iteramos cada caracter y retornamos su traduccion
            chainToMorse += this.matchToNatural(substr[i])+" ";
        }
        return chainToMorse+"  ";
    }
    // This function matches an element of morse code
    public String matchToNatural(String string){
        String found="";
        for (Map.Entry<String , String> entry : this.morseLetterParser.entrySet()) {
            if (entry.getValue().equals(string)){
                found = entry.getKey();
            }
        }
        return found;
    }
    // END MORSE TO NATURAL ==================================================

    // GETTERS AND SETTERS =================================================

    public String getMorseCode() {
        return morseCode;
    }

    public void setMorseCode(String morseCode) {
        this.morseCode = morseCode;
    }

    public String getLanguageNatural() {
        return languageNatural;
    }

    public void setLanguageNatural(String languageNatural) {
        this.languageNatural = languageNatural;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    // END GETTERS AND SETTERS =================================================
}

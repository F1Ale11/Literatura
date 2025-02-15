package com.oraclealura.Literatura.model;

import lombok.Getter;

import java.text.Normalizer;
import java.util.Arrays;

public enum Lenguaje {
    ESPANIOL("es","Español"),
    INGLES("en","Inglés"),
    PORTUGUES("pt","Portugués"),
    FRANCES("fr","Francés"),
    ITALIANO("it", "Italiano"),
    ALEMAN("de", "Alemán");

    private String lenguajeGutendex;
    @Getter
    private String lenguajeEspanol;

    Lenguaje (String lenguajeGutendex, String lenguajeEspanol){
        this.lenguajeGutendex = lenguajeGutendex;
        this.lenguajeEspanol = lenguajeEspanol;
    }

    public static Lenguaje fromGutendex(String texto) {
        for (Lenguaje lenguaje : Lenguaje.values()) {
            if (lenguaje.lenguajeGutendex.equals(texto)) {
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ningún lenguaje encontrado: " + texto);
    }

    public static Lenguaje fromEspanol(String texto) {
        String textoNormalizado = normalizarTexto(texto);
        for (Lenguaje lenguaje : Lenguaje.values()) {
            if (normalizarTexto(lenguaje.lenguajeEspanol).equals(textoNormalizado)) {
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ningún lenguaje encontrado: " + texto + ". Lenguajes disponibles: " +
                Arrays.toString(Lenguaje.values()));
    }

    public static String normalizarTexto(String input) {
        if (input == null) {
            return null;
        }
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }
}
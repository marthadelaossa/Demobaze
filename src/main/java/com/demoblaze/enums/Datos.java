package com.demoblaze.enums;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public enum Datos {

    NAME("Juan Perez"),
    COUNTRY ("Colomnbia"),

    CITY("Bogota"),
    CARD ("12345678910"),

    MONTH (String.valueOf(LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")))),

    YEAR (String.valueOf(LocalDate.now().getYear()));


    private final String valor;
    Datos(String valor) {
        this.valor = valor;
    }

    public static String valor (Datos datos){
        return datos.valor;
    }

}

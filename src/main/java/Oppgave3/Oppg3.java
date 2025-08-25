package Oppgave3;

import Oppgave2.Kjonn;

import java.util.Arrays;
import java.util.List;

public class Oppg3 {
    public static void main(String[] args) {

        List<Ansatt> ansatte = Arrays.asList(
                new Ansatt("ansatt1", "etternavn1", Kjonn.MALE, "Stilling", 850000),
                new Ansatt("ansatt2", "etternavn2", Kjonn.FEMALE, "Stilling", 950000),
                new Ansatt("ansatt3", "etternavn3", Kjonn.MALE, "Stilling", 1050000),
                new Ansatt("ansatt4", "etternavn4", Kjonn.FEMALE, "Stilling", 1150000),
                new Ansatt("ansatt5", "etternavn5", Kjonn.MALE, "Stilling", 1250000)
        );

        /*
        Løsningene skal være funksjonelle, dvs. bruk stream(), map(), filter(), reduce(), osv. Alle
        løsningene/svarene skal lagres i variabler som deretter skrives ut på skjermen.

        a) Lag en ny liste som kun inneholder etternavnene til de ansatte.
        b) Finn ut antall kvinner blant de ansatte.
        c) Regn ut gjennomsnittslønnen til kvinnene.
        d) Gi alle sjefer (stilling inneholder noe med "sjef") en lønnsøkning på 7% ved å bruke
        streams direkte i stedet for metoden du laget i Oppg2. Skriv ut listen av ansatte etter
        lønnsøkningen.
        e) Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,-
        f) Skriv ut alle de ansatte med System.out.println() uten å bruke løkke.
        g) Finn den/de ansatte som har lavest lønn.
        h) Finn ut summen av alle heltall i [1, 1000> som er delelig med 3 eller 5.
         */




    }
}

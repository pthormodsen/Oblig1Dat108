package Oppgave3;

import Oppgave2.Kjonn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Oppg3 {
    public static void main(String[] args) {

        List<Ansatt> ansatte = Arrays.asList(
                new Ansatt("ansatt1", "etternavn1", Kjonn.MALE, "sjef", 850000),
                new Ansatt("ansatt2", "etternavn2", Kjonn.FEMALE, "Stilling", 950000),
                new Ansatt("ansatt3", "etternavn3", Kjonn.MALE, "Sjef", 1050000),
                new Ansatt("ansatt4", "etternavn4", Kjonn.FEMALE, "Stilling", 1150000),
                new Ansatt("ansatt5", "etternavn5", Kjonn.MALE, "Sjef", 850000)
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

        //a
        List<String> etternavn = ansatte.stream()
                .map(Ansatt::getEtternavn)
                .toList();
        System.out.println(etternavn);

        //b
        long kvinner = ansatte.stream()
                .filter(e -> (e.getKjonn() == Kjonn.FEMALE))
                .count();
        System.out.println(kvinner);

        //c
        double gjennomsnittKvinner = ansatte.stream()
                .filter(e -> (e.getKjonn() == Kjonn.FEMALE))
                .mapToInt(Ansatt::getAarslonn)
                .average()
                .orElse(0);
        System.out.println(gjennomsnittKvinner);

        //d
        ansatte.stream()
                .filter(e -> (e.getStilling().toLowerCase().contains("sjef")))
                .forEach(e -> e.setAarslonn((int) (e.getAarslonn() * 1.07)));
        ansatte.forEach(System.out::println);

        //e
        boolean erSant = ansatte.stream()
                .anyMatch(e -> e.getAarslonn() > 800000);
        System.out.println(erSant);

        //f
        ansatte.forEach(System.out::println);

        //g
        int minLonn = ansatte.stream()
                .mapToInt(Ansatt::getAarslonn)
                .min()
                .orElse(0);
        System.out.println(minLonn);
        List<Ansatt> minstLonnAnsatt = ansatte.stream()
                .filter(a -> a.getAarslonn() == minLonn)
                .collect(Collectors.toList());
        System.out.println(minstLonnAnsatt);

        //h
        int sum = IntStream.range(1, 1000)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
        System.out.println(sum);
    }

}

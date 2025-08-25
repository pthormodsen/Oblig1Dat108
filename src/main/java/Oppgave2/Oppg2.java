package Oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Oppg2 {

    public static void main(String[] args) {
        List<Ansatt> ansatte = Arrays.asList(
                new Ansatt("ansatt1", "etternavn1", Kjonn.MALE, "Stilling", 850000),
                new Ansatt("ansatt2", "etternavn2", Kjonn.FEMALE, "Stilling", 950000),
                new Ansatt("ansatt3", "etternavn3", Kjonn.MALE, "Stilling", 1050000),
                new Ansatt("ansatt4", "etternavn4", Kjonn.FEMALE, "Stilling", 1150000),
                new Ansatt("ansatt5", "etternavn5", Kjonn.MALE, "Stilling", 1250000)
        );

        System.out.println("Ansatte før tillegg");
        skrivUt(ansatte);
        System.out.println();

        //Fast kronetillegg
        int kronetillegg = 50000;
        lonnsoppgjor(ansatte, a -> a.getAarslonn() + kronetillegg);
        System.out.println("Ansatte etter kronetillegg");
        skrivUt(ansatte);
        System.out.println();

        //Fast prosenttillegg
        double prosenttillegg = 1.05;
        lonnsoppgjor(ansatte, a -> (int)(a.getAarslonn() * prosenttillegg));
        System.out.println("Ansatte etter prosenttillegg");
        skrivUt(ansatte);
        System.out.println();

        //Fast kronetillegg vist lav lønn
        int lavLonnKronetillegg = 20000;
        int grenseLonn = 1000000;
        lonnsoppgjor(ansatte, a -> {
            if(a.getAarslonn() < grenseLonn){
                return a.getAarslonn() + lavLonnKronetillegg;
            } else {
                return a.getAarslonn();
            }
        });
        System.out.println("Ansatte etter lavLonnKronetillegg");
        skrivUt(ansatte);
        System.out.println();

        //Fast prosenttillegg vist mann
        double mannTilegg = 1.5;
        lonnsoppgjor(ansatte, a -> {
            if(a.getKjonn() == Kjonn.MALE){
                return (int)(a.getAarslonn() * mannTilegg);
            } else {
                return a.getAarslonn();
            }
        });
        System.out.println("Ansatte etter manntilegg");
        skrivUt(ansatte);

    }

    private static void skrivUt(List<Ansatt> ansatte){
        for(Ansatt a : ansatte){
            System.out.println(a.getFornavn() + " " + a.getEtternavn() + " " + a.getKjonn() + " " + a.getStilling() + " " + a.getAarslonn());
        }
    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon){
        for(Ansatt a : ansatte){
            a.setAarslonn(funksjon.apply(a));
        }
    }

}

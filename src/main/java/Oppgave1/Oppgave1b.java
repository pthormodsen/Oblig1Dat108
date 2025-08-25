package Oppgave1;

import java.util.function.BiFunction;

public class Oppgave1b {

    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> funksjon){
        return funksjon.apply(a,b);
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> summer = (a,b) -> a+b;
        BiFunction<Integer, Integer, Integer> storste = (a,b) -> Math.max(a,b);
        BiFunction<Integer, Integer, Integer> diff = (a,b) -> Math.abs(a-b);

        int sum = beregn(12, 13, summer);
        System.out.println(sum);

        int stor = beregn(-5, 3, storste);
        System.out.println(stor);

        int avstand = beregn(54, 45, diff);
        System.out.println(avstand);

    }

}

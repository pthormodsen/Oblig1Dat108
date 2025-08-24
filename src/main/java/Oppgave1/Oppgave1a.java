package Oppgave1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Oppgave1a {

    public static void main(String[] args) {

        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

        System.out.println(listen);

        Comparator<String> sorter = (a,b) -> Integer.parseInt(a) - Integer.parseInt(b);
        Collections.sort(listen, sorter);

        System.out.println("Sortert: " + listen);

    }

}

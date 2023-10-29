package br.com.ornitorrinco.javanews.java12.preview;

import java.time.DayOfWeek;
import java.util.*;

import static java.time.DayOfWeek.*;

// JEP 325: Switch Expressions (Preview)
public class SwitchExpressions {

    public static void main(String[] args) {

        switch (getRandomDayOfWeek()) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY                -> System.out.println(7);
            case THURSDAY, SATURDAY     -> System.out.println(8);
            case WEDNESDAY              -> System.out.println(9);
        }


    }

    private static DayOfWeek getRandomDayOfWeek() {
        List<DayOfWeek> values = Arrays.asList(values());
         return values.get(new Random().nextInt(values.size()));
    }

}

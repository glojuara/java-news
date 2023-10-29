package br.com.ornitorrinco.javanews.java13.preview;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.time.DayOfWeek.values;

// JEP 354: Switch Expressions (Second Preview)
public class SwitchExpressions {


    public static void main(String[] args) {

        var day = getRandomDayOfWeek();

        int j = switch (day) {
            case MONDAY  -> 0;
            case TUESDAY -> 1;
            default      -> {
                int k = day.getValue();
                yield k;
            }
        };


        System.out.println(j);


    }

    private static DayOfWeek getRandomDayOfWeek() {
        List<DayOfWeek> values = Arrays.asList(values());
        return values.get(new Random().nextInt(values.size()));
    }

}

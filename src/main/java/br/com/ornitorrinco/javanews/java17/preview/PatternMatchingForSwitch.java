package br.com.ornitorrinco.javanews.java17.preview;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.time.DayOfWeek.values;

// JEP 406: Pattern Matching for switch (Preview)
public class PatternMatchingForSwitch {


    public static void main(String[] args) {

        DayOfWeek day = getRandomDayOfWeek(); // Assign here the value
        System.out.println(switch (day) {
            case SUNDAY, SATURDAY -> "Weekend";
            case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> "Weekday";
        });

        System.out.println(switch (day) {
            case SUNDAY, SATURDAY -> "Weekend";
            case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> {
                System.out.println("do work");
                yield "Weekday";
            }
        });

    }

    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default     -> o.toString();
        };
    }

    private static DayOfWeek getRandomDayOfWeek() {
        List<DayOfWeek> values = Arrays.asList(values());
        return values.get(new Random().nextInt(values.size()));
    }


}

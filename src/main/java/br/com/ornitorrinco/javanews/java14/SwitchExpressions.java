package br.com.ornitorrinco.javanews.java14;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// JEP 361: Switch Expressions
public class SwitchExpressions {

    public static void main(String[] args) {


        int result = switch (getRamdomString()) {
            case "Foo":
                yield 1;
            case "Bar":
                yield 2;
            default:
                System.out.println("Neither Foo nor Bar, hmmm...");
                yield 0;
        };

        System.out.println(result);

    }

    private static String getRamdomString() {
        List<String> values = Arrays.asList("Foo", "Bar", "Neither");
        return values.get(new Random().nextInt(values.size()));
    }

}

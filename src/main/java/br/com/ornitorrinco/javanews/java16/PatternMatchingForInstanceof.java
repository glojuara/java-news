package br.com.ornitorrinco.javanews.java16;

// JEP 394: Pattern Matching for instanceof
public class PatternMatchingForInstanceof {

    public static void main(String[] args) {

        var obj = "Sou uma String";

        if (obj instanceof String s) {
            System.out.println(s.length() + ": " + s);
        }

    }

}

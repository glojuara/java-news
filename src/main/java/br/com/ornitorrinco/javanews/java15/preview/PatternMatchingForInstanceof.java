package br.com.ornitorrinco.javanews.java15.preview;

// JEP 375: Pattern Matching for instanceof (Second Preview)
public class PatternMatchingForInstanceof {

    public static void main(String[] args) {

        var obj = "Sou uma String";

        if (obj instanceof String s) {
            System.out.println(s.length() + ": " + s);
        }

    }

}

package br.com.ornitorrinco.javanews.java14.preview;

// JEP 305: Pattern Matching for instanceof (Preview)
public class PatternMatchingForInstanceof {

    public static void main(String[] args) {

        var obj = "Sou uma String";

        if (obj instanceof String s) {
            System.out.println(s.length() + ": " + s);
        }

    }

}

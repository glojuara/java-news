package br.com.ornitorrinco.javanews.java21.preview;

// JEP 445: Unnamed Classes and Instance Main Methods (Preview)
public class UnnamedClassesAndInstanceMainMethods {

    void main(){
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        new UnnamedClassesAndInstanceMainMethods(){}.main();
    }



}

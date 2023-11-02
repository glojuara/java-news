package br.com.ornitorrinco.javanews.java21;

// JEP 431: Sequenced Collections

import java.util.List;

public class SequencedCollections {

    public static void main(String[] args) {


        List<String> myList = List.of("test-1", "test-2", "test-3");
        myList.forEach(System.out::println);
        System.out.println();
        myList.reversed().forEach(System.out::println);






    }

}

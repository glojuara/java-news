package br.com.ornitorrinco.javanews.java10;

import java.util.ArrayList;

// JEP 286: Local-Variable Type Inference
public class LocalVariableTypeInference {

    public static void main(String[] args) {

        var list = new ArrayList<String>();  // infers ArrayList<String>
        var stream = list.stream();          // infers Stream<String>

        System.out.println(stream.count());

    }

}

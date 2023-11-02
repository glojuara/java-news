package br.com.ornitorrinco.javanews.java21;

// JEP 440: Record Patterns
public class RecordPatterns {

    public static void main(String[] args) {
        var box = new Box<String>("my-box");
        test1(new Box<>(box));
        test2(new Pair<>(new C(), new D()));
    }


    record Box<T>(T t) {}
    static void test1(Box<Box<String>> bbs) {
        if (bbs instanceof Box<Box<String>>(Box(var s))) {
            System.out.println("String " + s);
        }
    }


    class A {}
    class B extends A {}
    sealed interface I permits C, D {}
    static final class C implements I {}
    static final class D implements I {}
    record Pair<T>(T x, T y) {}

    Pair<A> p1;
    Pair<I> p2;

    static void test2(Pair<I> p2) {
        switch (p2) {
            case Pair<I>(I i, C c) -> System.out.println("Pair<I>(I i, C c)");
            case Pair<I>(I i, D d) -> System.out.println("Pair<I>(I i, D d)");
        }

        switch (p2) {
            case Pair<I>(C c, I i) -> System.out.println("Pair<I>(C c, I i)");
            case Pair<I>(D d, C c) -> System.out.println("Pair<I>(D d, C c)");
            case Pair<I>(D d1, D d2) -> System.out.println("Pair<I>(D d1, D d2)");
        }
    }




}

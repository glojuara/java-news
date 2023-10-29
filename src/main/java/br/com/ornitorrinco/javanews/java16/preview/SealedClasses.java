package br.com.ornitorrinco.javanews.java16.preview;

// JEP 397: Sealed Classes (Second Preview)
public class SealedClasses {

    abstract sealed static class Shape {}
    final class Circle extends Shape {}
    final class Rectangle extends Shape {}
    final class Square extends Shape {}


    public sealed interface Expr permits ConstantExpr, PlusExpr, TimesExpr, NegExpr {}
    public final class ConstantExpr implements Expr {}
    public final class PlusExpr     implements Expr {}
    public final class TimesExpr    implements Expr {}
    public final class NegExpr      implements Expr {}


}

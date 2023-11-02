package br.com.ornitorrinco.javanews.java21.preview;

// JEP 443: Unnamed Patterns and Variables (Preview)
public class UnnamedPatternsAndVariables {

    static sealed abstract class Ball permits RedBall, BlueBall, GreenBall { }
    static final  class RedBall   extends Ball { }
    static final  class BlueBall  extends Ball { }
    static final  class GreenBall extends Ball { }

    record Box<T extends Ball>(T content) { }

    public static void main(String[] args) {

        Box<Ball> b = new Box<>(new GreenBall());

        switch (b) {
            case Box(RedBall _), Box(BlueBall _) -> System.out.println("condition 1 -> " + b.content);
            case Box(GreenBall _)                -> System.out.println("condition 2 -> " + b.content);
            case Box(_)                          -> System.out.println("condition 3");
        }

    }

}

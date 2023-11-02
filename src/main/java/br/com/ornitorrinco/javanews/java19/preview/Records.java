package br.com.ornitorrinco.javanews.java19.preview;

// JEP 405: Record Patterns (Preview)
public class Records {

    public static void main(String[] args) {
        printSum(new Point(1,2 ));
    }

    record Point(int x, int y) {}

    static void printSum(Object o) {
        if (o instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x+y);
        }
    }

}

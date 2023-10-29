package br.com.ornitorrinco.javanews.java15.preview;

// JEP 384: Records (Second Preview)
public class Records {

    public static void main(String[] args) {
        Range range = new Range(20, 30);
        System.out.println(range);
    }


    public static record Range(int lo, int hi) {
        public Range {
            if (lo > hi)  /* referring here to the implicit constructor parameters */
                throw new IllegalArgumentException(String.format("(%d,%d)", lo, hi));
        }
    }

}

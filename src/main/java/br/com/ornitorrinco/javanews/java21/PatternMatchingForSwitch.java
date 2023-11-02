package br.com.ornitorrinco.javanews.java21;

// JEP 441: Pattern Matching for switch
public class PatternMatchingForSwitch {



    public static void main(String[] args) {
        System.out.println(formatterPatternSwitch(1L));
        testFooBarNew(null);
        testStringOld("YES");
        testStringNew("NO");
        testStringEnhanced("n");

        exhaustiveSwitchWithoutEnumSupport(Suit.DIAMONDS);
        exhaustiveSwitchWithBetterEnumSupport(new Tarot());

        typeTester(Color.BLUE);
        typeTester(new Point(1,2));

        StringBuffer stringBuffer = new StringBuffer("oi");

        first(stringBuffer);
        first(stringBuffer.toString());

        testSpecialCases(1);
        testSpecialCases(10);
        testSpecialCases(-10);

    }


    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> obj.toString();
        };
    }

    static void testFooBarNew(String s) {
        switch (s) {
            case null         -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok");
        }
    }

    static void testStringOld(String response) {
        switch (response) {
            case null -> { }
            case String s -> {
                if (s.equalsIgnoreCase("YES"))
                    System.out.println("You got it");
                else if (s.equalsIgnoreCase("NO"))
                    System.out.println("Shame");
                else
                    System.out.println("Sorry?");
            }
        }
    }

    static void testStringNew(String response) {
        switch (response) {
            case null -> { }
            case String s
                    when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it");
            }
            case String s
                    when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame");
            }
            case String s -> {
                System.out.println("Sorry?");
            }
        }
    }

    static void testStringEnhanced(String response) {
        switch (response) {
            case null -> { }
            case "y", "Y" -> {
                System.out.println("You got it");
            }
            case "n", "N" -> {
                System.out.println("Shame");
            }
            case String s
                    when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it");
            }
            case String s
                    when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame");
            }
            case String s -> {
                System.out.println("Sorry?");
            }
        }
    }


    sealed interface CardClassification permits Suit, Tarot {}
    public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
    static final class Tarot implements CardClassification {}

    static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
        switch (c) {
            case Suit s when s == Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit s when s == Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit s when s == Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit s -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }


    static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        switch (c) {
            case Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit.SPADES -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }


    record Point(int i, int j) {}
    enum Color { RED, GREEN, BLUE; }

    static void typeTester(Object obj) {
        switch (obj) {
            case null     -> System.out.println("null");
            case String s -> System.out.println("String");
            case Color c  -> System.out.println("Color: " + c.toString());
            case Point p  -> System.out.println("Record class: " + p.toString());
            case int[] ia -> System.out.println("Array of ints of length" + ia.length);
            default       -> System.out.println("Something else");
        }
    }

    static void first(Object obj) {
        switch (obj) {
            case String s ->
                    System.out.println("A string: " + s);
            case CharSequence cs ->
                    System.out.println("A sequence of length " + cs.length());
            default -> {}
        }
    }

    static void testSpecialCases(Integer i) {
        switch (i) {
            case -1, 1 -> System.out.println("Special case");
            case Integer j when j > 0 -> System.out.println("Positive: " + j);
            case Integer j -> System.out.println("Negative: " + j);
        }
    }

}

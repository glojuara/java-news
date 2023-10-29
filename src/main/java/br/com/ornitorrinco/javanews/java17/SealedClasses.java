package br.com.ornitorrinco.javanews.java17;

// JEP 409: Sealed Classes
public class SealedClasses {

    sealed interface Celestial permits Planet, Star, Comet {  }

    final class Planet implements Celestial {  }
    final class Star   implements Celestial {  }
    final class Comet  implements Celestial {  }

}

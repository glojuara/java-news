package br.com.ornitorrinco.javanews.java14.preview;
import javax.script.ScriptException;

// JEP 368: Text Blocks (Second Preview)
public class TextBlocks {


    /*
        String::stripIndent(): used to strip away incidental white space from the text block content
        String::translateEscapes(): used to translate escape sequences
        String::formatted(Object... args): simplify value substitution in the text block
    */


    public static void main(String[] args) throws ScriptException {

        String html = """
              <html>\r
                  <body>\r
                      <p>Hello, world</p>\r
                  </body>\r
              </html>\r
              """;

        System.out.println(html);

        String source = """
                public void print(%s object) {
                    System.out.println(Objects.toString(object));
                }
                """.formatted("Object");

        System.out.println(source);



    }


}

package br.com.ornitorrinco.javanews.java21.preview;

// JEP 430: String Templates (Preview)

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.StringTemplate.STR;

@RestController
@RequestMapping("/string-templates")
public class StringTemplates {

    @GetMapping
    public ResponseEntity<String> html() {

        var name = "Guilherme";
        var title = "Sample";

        var text = STR."Hello, my name is \{name}";

        var html =  STR."""
        <html>
          <head>
            <title>\{title}</title>
          </head>
          <body>
            <h1>\{text}</h1>
          </body>
        </html>
        """;

        return ResponseEntity.ok(html);
    }

}

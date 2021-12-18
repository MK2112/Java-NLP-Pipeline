package org.example;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utilizing these sources:
 *  http://opennlp.sourceforge.net/models-1.5/
 *  https://www.tutorialkart.com/opennlp/tokenizer-example-in-apache-opennlp/
 */
public class Tokenizer {
    public String[] run(String language, String text) throws IOException {
        InputStream modelIn;

        if (language.equals("deu")) {
            modelIn = new FileInputStream("src/resources/de-tokenizer.bin");
        } else {
            modelIn = new FileInputStream("src/resources/en-tokenizer.bin");
        }

        TokenizerModel model = new TokenizerModel(modelIn);
        TokenizerME tokenizer = new TokenizerME(model);

        return tokenizer.tokenize(text);
    }
}
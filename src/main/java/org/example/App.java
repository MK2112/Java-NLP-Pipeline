package org.example;

import java.io.IOException;
import java.util.HashMap;

/**
 * Utilizing these sources:
 * http://opennlp.sourceforge.net/models-1.5/
 * https://github.com/Ruthwik/Language-Detection
 * https://stackoverflow.com/questions/4570751/what-tag-set-is-used-in-opennlps-german-maxent-model
 */
public class App 
{
    public static void main( String[] args ) {
        LanguageTagger lt = new LanguageTagger();
        Tokenizer tk = new Tokenizer();
        POSTagger pos = new POSTagger();

        // a simple dummy pipeline
        String text = "Das ist ein Test.";

        try {
            String language = lt.run(text);
            String[] tokens = tk.run(language, text);
            HashMap<Integer, String> nouns = pos.run(language, tokens);

            for (Integer key: nouns.keySet()) {
                System.out.println(nouns.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

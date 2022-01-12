package org.example;

import java.io.IOException;

/**
 * Utilizing these sources:
 * http://opennlp.sourceforge.net/models-1.5/
 * https://github.com/Ruthwik/Language-Detection
 * https://stackoverflow.com/questions/4570751/what-tag-set-is-used-in-opennlps-german-maxent-model
 * https://www.sketchengine.eu/german-stts-part-of-speech-tagset/
 */
public class App 
{
    public static void main( String[] args ) {
        LanguageTagger languageTagger = new LanguageTagger();
        Tokenizer tokenizer = new Tokenizer();
        POSTagger posTagger = new POSTagger();

        // a simple dummy pipeline
        String text = "Das ist ein Test. Das ist ein Test, der um viele Ebenen komplexer ist.";

        // desired output: {[Test, [Das, ein]],[Test, [Das, ein, der]],[Ebenen]}

        try {
            String language = languageTagger.run(text);
            String[] tokens = tokenizer.run(language, text);
            String[] tags = posTagger.run(language, tokens);

            for (int i = 0; i < tokens.length; i++) {
                System.out.print(tokens[i] + " - ");
                System.out.print(tags[i]+ "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

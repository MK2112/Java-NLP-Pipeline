package org.example;

import org.apache.uima.UimaContext;
import org.apache.uima.cas.AbstractCas;
import org.apache.uima.cas.SofaID;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.Session;
import org.apache.uima.util.InstrumentationFacility;
import org.apache.uima.util.Logger;
import org.apache.uima.util.Settings;
import org.dkpro.core.rftagger.RfTagger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
        String text = "Das ist ein Test. Das ist ein Test, der um viele Ebenen komplexer ist. Das Auto fährt viel zu langsam.";

        // desired output: {[Test, [Das, ein]],[Test, [Das, ein, der]],[Ebenen]}
        String[] tokens = new String[0];
        String[] tags = new String[0];
        try {
            String language = languageTagger.run(text);
            tokens = tokenizer.run(language, text);
            tags = posTagger.run(language, tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // split into sentences
        ArrayList<ArrayList<Word>> sentences = new ArrayList<>();
        ArrayList<Word> sentence = new ArrayList<>();
        Pattern p = Pattern.compile("[?!.]");

        for (int i = 0; i < tokens.length; i++) {
            sentence.add(new Word(tokens[i], tags[i], i));
            if (p.matcher(tokens[i]).find()) {
                sentences.add(sentence);
                sentence = new ArrayList<>();
            }
        }

        for (ArrayList<Word> words : sentences) {
            for (Word word : words) {
                System.out.print(word.token + "[" + word.tag + "] ");
            }
            System.out.println("");
        }

        RfTagger rfTagger = new RfTagger();


    }
}

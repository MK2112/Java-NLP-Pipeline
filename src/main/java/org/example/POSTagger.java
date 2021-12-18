package org.example;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Utilized sources:
 *  https://github.com/mmm0469/apache-opennlp-examples/blob/master/POSTaggerExample.java
 */

public class POSTagger {

    // TODO: Remove before flight
    public POSTagger() {
        tagLex = generateTagLex();
    }
    private HashMap<String, String> tagLex;

    public HashMap<Integer, String> run(String language, String[] tokens) throws IOException {
        HashMap<Integer, String> nouns = new HashMap<Integer, String>();
        // Parts-Of-Speech Tagging
        // reading parts-of-speech model to a stream
        InputStream posModelIn = new FileInputStream("src/resources/de-pos-maxent.bin");
        // loading the parts-of-speech model from stream
        POSModel posModel = new POSModel(posModelIn);
        // initializing the parts-of-speech tagger with model
        POSTaggerME posTagger = new POSTaggerME(posModel);
        // Tagger tagging the tokens
        String tags[] = posTagger.tag(tokens);

        for (int i = 0; i < tags.length; i++) {
            if (tags[i].equals("NN")) {
                nouns.put(i, tokens[i]);
            }
        }

        return nouns;
    }

    public HashMap<String, String> generateTagLex() {
        HashMap<String, String> lex = new HashMap<String, String>();

        lex.put("ADJA", "Attributives Adjektiv");
        lex.put("ADJD", "Adverbiales oder prädikatives Adjektiv");
        lex.put("ADV", "Adverb");
        lex.put("APPR", "Präposition; Zirkumposition links");
        lex.put("APPRART", "Präposition mit Artikel");
        lex.put("APPO", "Postposition");
        lex.put("APZR", "Zirkumposition rechts");
        lex.put("ART", "Bestimmer oder unbestimmer Artikel");
        lex.put("CARD", "Kardinalzahl");
        lex.put("FM", "Fremdsprachichles Material");
        lex.put("ITJ", "Interjektion");
        lex.put("KOUI", "unterordnende Konjunktion mit zu und Infinitiv");
        lex.put("KOUS", "unterordnende Konjunktion mit Satz");
        lex.put("KON", "nebenordnende Konjunktion");
        lex.put("KOKOM", "Vergleichskonjunktion");
        lex.put("NN", "normales Nomen");
        lex.put("NE", "Eigennamen");
        lex.put("PDS", "substituierendes Demonstrativpronomen");
        lex.put("PDAT", "attribuierendes Demonstrativpronomen");
        lex.put("PIS", "substituierendes Indefinitpronomen");
        lex.put("PIAT", "attribuierendes Indefinitpronomen ohne Determiner");
        lex.put("PIDAT", "attribuierendes Indefinitpronomen mit Determiner");
        lex.put("PPER", "irreflexives Personalpronomen");
        lex.put("PPOSS", "substituierendes Possessivpronomen");
        lex.put("PPOSAT", "attribuierendes Possessivpronomen");
        lex.put("PRELS", "substituierendes Relativpronomen");
        lex.put("PRELAT", "attributierendes Relativpronomen");
        lex.put("PRF", "reflexives Personalpronomen");
        lex.put("PROAV", "Pronominaladverb");
        lex.put("PWS", "substituierendes Interrogativpronomen");
        lex.put("PWAT", "attribuierendes Interrogativpronomen");
        lex.put("PWAV", "adverbiales Interrogativ- oder Relativpronomen");
        lex.put("PAV", "Pronominaladverb");
        lex.put("PTKZU", "zu vor Infinitiv");
        lex.put("PTKNEG", "Negationspartikel");
        lex.put("PTKVZ", "abgetrennter Verbzusatz");
        lex.put("PTKANT", "Antwortpartikel");
        lex.put("PTKA", "Partikel bei Adjektiv oder Adverb");
        lex.put("TRUNC", "Kompositions-Erstglied");
        lex.put("VVFIN", "finites Verb, voll");
        lex.put("VVIMP", "Imperativ, voll");
        lex.put("VVINF", "Infinitiv");
        lex.put("VVIZU", "Infinitiv mit zu");
        lex.put("VVPP", "Partizip Perfekt");
        lex.put("VAFIN", "finites Verb, aux");
        lex.put("VAIMP", "Imperativ, aux");
        lex.put("VAINF", "Infinitiv, aux");
        lex.put("VAPP", "Partizip Perfekt");
        lex.put("VMFIN", "finites Verb, modal");
        lex.put("VMINF", "Infinitiv, modal");
        lex.put("VMPP", "Partizip Perfekt, modal");
        lex.put("XY", "Nichtwort, Sonderzeichen");
        lex.put("UNDEFINED", "Nicht definiert, zb. Satzzeichen");

        return lex;
    }

    public String getDescription(String tag) {
        String description = tagLex.get(tag);
        if(description == null){
            return tagLex.get("UNDEFINED");
        }
        return description;
    }
}

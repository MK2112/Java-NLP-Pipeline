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

    public String[] run(String language, String[] tokens) throws IOException {
        // Parts-Of-Speech Tagging
        // reading parts-of-speech model to a stream
        InputStream posModelIn = new FileInputStream("src/resources/de-pos-maxent.bin");
        // loading the parts-of-speech model from stream
        POSModel posModel = new POSModel(posModelIn);
        // initializing the parts-of-speech tagger with model
        POSTaggerME posTagger = new POSTaggerME(posModel);
        // Tagger tagging the tokens
        return posTagger.tag(tokens);
    }

}

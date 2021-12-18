package org.example;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.File;
import java.io.IOException;

/**
 * Utilizing these sources:
 *  http://opennlp.sourceforge.net/models-1.5/
 *  https://github.com/Ruthwik/Language-Detection
 */
public class LanguageTagger {

    public String run(String text) throws IOException {
        // load the trained Language Detector Model file
        File modelFile = new File("src/resources/langdetect-183.bin");
        LanguageDetectorModel trainedModel = new LanguageDetectorModel(modelFile);
        // load the model
        LanguageDetector languageDetector = new LanguageDetectorME(trainedModel);

        Language[] languages = languageDetector.predictLanguages(text);
        return languages[0].getLang();
    }

}

# Java NLP Pipeline

## Description
A Java-based NLP pipeline leveraging OpenNLP and pre-trained models.
This is a proof of concept regarding potential uses for Java in NLP.

## Overview
This repository contains a proof of concept for a Java-based NLP-Pipeline.
The Pipeline was was built largely with OpenNLP and pre-trained models.

The project consists of these components:
* [App](src/main/java/org/example/App.java) contains main method, creates NLP componetens and runs them in order,
* [LanguageTagger](src/main/java/org/example/LanguageTagger.java) takes in text and returns the most likely of 103 languages, 
* [Tokenizer](src/main/java/org/example/Tokenizer.java) content-based splitting of words (e.g. don't -> do, n't), 
* [POSTagger](src/main/java/org/example/POSTagger.java) determines word properties per token in a token set

### Dependencies
* Java 8

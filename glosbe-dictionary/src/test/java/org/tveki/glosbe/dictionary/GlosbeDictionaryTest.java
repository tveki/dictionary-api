/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.glosbe.dictionary;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.tveki.dictionary.api.Dictionary;
import org.tveki.dictionary.api.Language;
import org.tveki.dictionary.api.TranslateRequest;
import org.tveki.dictionary.api.TranslateResponse;

/**
 *
 * @author tveki
 */
public class GlosbeDictionaryTest {

    Dictionary dictionary;

    @Before
    public void startUp(){
        dictionary = new GlosbeDictionary();
    }

    @Test
    public void testTranslateFromEnglishToHungarian() {
        TranslateRequest request = prepareEnglish2HungarianRequest();
        request.setPhrase("dog");

        TranslateResponse response = dictionary.translate(request);
        assertFalse(response.getTranslations().isEmpty());
        print(response);
    }

    @Test
    public void testTranslateFromGermanToHungarian1() {
        TranslateRequest request = prepareGerman2HungarianRequest();
        request.setPhrase("edel");

        TranslateResponse response = dictionary.translate(request);
        assertFalse(response.getTranslations().isEmpty());
        print(response);
    }

    @Test
    public void testTranslateFromGermanToHungarian2() {
        TranslateRequest request = prepareGerman2HungarianRequest();
        request.setPhrase("Geständnis");

        TranslateResponse response = dictionary.translate(request);
        assertFalse(response.getTranslations().isEmpty());
        print(response);
    }

    private TranslateRequest prepareGerman2HungarianRequest() {
        TranslateRequest request = new TranslateRequest();
        request.setFrom(Language.GERMAN);
        request.setTo(Language.HUNGARIAN);
        return request;
    }

    private TranslateRequest prepareEnglish2HungarianRequest() {
        TranslateRequest request = new TranslateRequest();
        request.setFrom(Language.ENGLISH);
        request.setTo(Language.HUNGARIAN);
        return request;
    }

    private void print(TranslateResponse response){
        System.out.println("----------------------------------");
        System.out.printf("phrase=%s (%s -> %s)%n", response.getPhrase(), response.getFrom().getISO2Code(), response.getTo().getISO2Code());
        for (String str : response.getTranslations()){
            System.out.println(str);
        }
    }

}

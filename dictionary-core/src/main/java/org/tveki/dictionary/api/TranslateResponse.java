/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.dictionary.api;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tveki
 */
public class TranslateResponse extends TranslationTask {

    private List<String> translations = new ArrayList<>();
    private List<String> meanings = new ArrayList<>();

    public void addTranslation(String translation){
        translations.add(translation);
    }

    public void addMeaning(String meaning){
        meanings.add(meaning);
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public List<String> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<String> meanings) {
        this.meanings = meanings;
    }

}

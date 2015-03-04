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
public class TranslateResponse extends TranslateObject {

    private List<String> translations = new ArrayList<>();

    public void addTranslation(String translation){
        translations.add(translation);
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

}

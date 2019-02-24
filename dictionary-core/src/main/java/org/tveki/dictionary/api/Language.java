/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.dictionary.api;

import java.util.Locale;

/**
 *
 * @author tveki
 */
public class Language {

    private Locale locale;

    public static final Language ENGLISH = new Language(Locale.ENGLISH);
    public static final Language GERMAN = new Language(Locale.GERMAN);
    public static final Language SPANISH = new Language(new Locale("es", "ES"));
    public static final Language ITALIAN = new Language(Locale.ITALIAN);
    public static final Language FRENCH = new Language(Locale.FRENCH);
    public static final Language HUNGARIAN = new Language(new Locale("hu"));

    private final static Language[] cache = {
        ENGLISH,
        GERMAN,
        SPANISH,
        ITALIAN,
        FRENCH,
        HUNGARIAN};

    public Language(Locale locale) {
        this.locale = locale;
    }

    /*
     *  ISO 639-1 language code (2 letters)
     *  see at http://en.wikipedia.org/wiki/ISO_639-1
     *
     */
    public String getISO2Code() {
        return locale.getLanguage();
    }

    /*
     *  ISO 639-3 language code (3 letters)
     *  see at http://en.wikipedia.org/wiki/List_of_ISO_639-3_codes
     *
     */
    public String getISO3Code() {
        return locale.getISO3Language();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public static Language[] values() {
        return cache;
    }

    public static Language byISO2(String code) {
        for (Language lang : values()) {
            if (lang.getISO2Code().equals(code)) {
                return lang;
            }
        }
        throw new IllegalArgumentException("Unknown language code: " + code);
    }

    public static Language byISO3(String code) {
        for (Language lang : values()) {
            if (lang.getISO3Code().equals(code)) {
                return lang;
            }
        }
        throw new IllegalArgumentException("Unknown language code: " + code);
    }

}

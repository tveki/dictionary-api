/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.dictionary.api;

import java.util.Locale;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tveki
 */
public class LanguageTest {


    @Test
    public void testISO_639() {
        assertThat(Language.ENGLISH.getISO2Code(), is(Locale.ENGLISH.getLanguage()));
        assertThat(Language.GERMAN.getISO2Code(), is(Locale.GERMAN.getLanguage()));
        assertThat(Language.FRENCH.getISO2Code(), is(Locale.FRENCH.getLanguage()));
        assertThat(Language.ITALIAN.getISO2Code(), is(Locale.ITALIAN.getLanguage()));
        assertThat(Language.HUNGARIAN.getISO2Code(), is(new Locale("hu").getLanguage()));
    }

    @Test
    public void testISO_639_3() {
        assertThat(Language.ENGLISH.getISO3Code(), is(Locale.ENGLISH.getISO3Language()));
        assertThat(Language.GERMAN.getISO3Code(), is(Locale.GERMAN.getISO3Language()));
        assertThat(Language.FRENCH.getISO3Code(), is(Locale.FRENCH.getISO3Language()));
        assertThat(Language.ITALIAN.getISO3Code(), is(Locale.ITALIAN.getISO3Language()));
        assertThat(Language.HUNGARIAN.getISO3Code(), is(new Locale("hu").getISO3Language()));
    }

}

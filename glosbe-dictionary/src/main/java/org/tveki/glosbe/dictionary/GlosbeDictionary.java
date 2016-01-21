/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tveki.glosbe.dictionary;

import java.net.URI;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.tveki.dictionary.api.Dictionary;
import org.tveki.dictionary.api.Language;
import org.tveki.dictionary.api.TranslateRequest;
import org.tveki.dictionary.api.TranslateResponse;
import org.tveki.glosbe.dictionary.model.GlosbeResponse;
import org.tveki.glosbe.dictionary.model.Meaning;
import org.tveki.glosbe.dictionary.model.Tuc;

/**
 *
 * @author tveki
 */
public class GlosbeDictionary implements Dictionary {

    private static final Logger LOG = Logger.getLogger(GlosbeDictionary.class.getName());


    public static final String GLOSBE_TRANSLATE_URI = "https://glosbe.com/gapi/translate";
    public static final String FROM = "from";
    public static final String DEST = "dest";
    public static final String FORMAT = "format";
    public static final String PRETTY = "pretty";
    public static final String PHRASE = "phrase";

    @Override
    public TranslateResponse translate(TranslateRequest request) {
        Client client = ClientBuilder.newClient();

        URI uri = createUriBuilder()
                .queryParam(FROM, request.getFrom().getISO3Code())
                .queryParam(DEST, request.getTo().getISO3Code())
                .queryParam(FORMAT, "json")
                .queryParam(PRETTY, "true")
                .queryParam(PHRASE, request.getPhrase())
                .build();

        WebTarget target = client.target(uri);

        LOG.fine(uri.toString());

        Response response = target
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get();

        GlosbeResponse glosbeResponse = response.readEntity(GlosbeResponse.class);

        TranslateResponse translateResponse = new TranslateResponse();

        translateResponse.setPhrase(glosbeResponse.getPhrase());
        translateResponse.setFrom(Language.byISO2(glosbeResponse.getFrom()));
        translateResponse.setTo(Language.byISO2(glosbeResponse.getDest()));

        for (Tuc tuc : glosbeResponse.getTuc()) {
            if (tuc.getPhrase() != null) {
                translateResponse.addTranslation(tuc.getPhrase().getText());
            }
            for (Meaning meaning : tuc.getMeanings()){
                translateResponse.addMeaning(meaning.getText());
            }
        }

        return translateResponse;
    }

    protected String getBaseUri() {
        return GLOSBE_TRANSLATE_URI;
    }

    protected UriBuilder createUriBuilder() {
        return UriBuilder.fromUri(getBaseUri());
    }

    protected URI buildURI(String... paths) {
        UriBuilder uriBuilder = createUriBuilder();
        for (String path : paths) {
            uriBuilder.path(path);
        }
        return uriBuilder.build();
    }

    protected String createURIPath(String... paths) {
        return buildURI(paths).toString();
    }

}

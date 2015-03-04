package org.tveki.glosbe.dictionary.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlosbeResponse {

    private String result;
    private String dest;
    private String phrase;
    private List<Tuc> tuc = new ArrayList<>();
    private String from;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public List<Tuc> getTuc() {
        return tuc;
    }

    public void setTuc(List<Tuc> tuc) {
        this.tuc = tuc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

}

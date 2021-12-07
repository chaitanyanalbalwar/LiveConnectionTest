package com.app.liveconnectiontest.models;

public class MovieModel {

    String id,adults,backdrop_path,original_lang,original_title,popularity;

    public MovieModel(String id, String adults, String backdrop_path, String original_lang, String original_title, String popularity) {
        this.id = id;
        this.adults = adults;
        this.backdrop_path = backdrop_path;
        this.original_lang = original_lang;
        this.original_title = original_title;
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_lang() {
        return original_lang;
    }

    public void setOriginal_lang(String original_lang) {
        this.original_lang = original_lang;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
}

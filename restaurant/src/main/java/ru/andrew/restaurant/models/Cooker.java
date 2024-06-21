package ru.andrew.restaurant.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Cooker {
    @JsonProperty()
    private int cookId;
    private String cookName;
    private boolean cookActive;

    public Cooker(int cookId, String cookName, boolean cookActive) {
        this.cookId = cookId;
        this.cookName = cookName;
        this.cookActive = cookActive;
    }

    public Cooker(){

    }

    public int getCookId() {
        return cookId;
    }

    public String getCookName() {
        return cookName;
    }

    public boolean isCookActive() {
        return cookActive;
    }
}

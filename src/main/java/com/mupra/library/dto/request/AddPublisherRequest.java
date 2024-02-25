package com.mupra.library.dto.request;

import javax.persistence.Column;

public class AddPublisherRequest {
    private String name;

    private int establishedYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }
}

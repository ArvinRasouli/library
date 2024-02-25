package com.mupra.library.dto.request;

import javax.persistence.Column;
import java.util.Date;

public class AddAuthorRequest {

    private String name;

    private Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

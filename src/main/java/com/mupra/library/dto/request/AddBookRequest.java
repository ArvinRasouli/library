package com.mupra.library.dto.request;

import com.mupra.library.entity.Author;
import com.mupra.library.entity.Publisher;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AddBookRequest {
    private String name;

    private int printYear;

    private int inventory;

    private int publisherId;

    private int authorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}

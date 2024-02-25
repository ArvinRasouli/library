package com.mupra.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "established_year")
    private int establishedYear;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Book> bookList;

    public Publisher() {

    }

    public Publisher(String name, int established_year) {
        this.name = name;
        this.establishedYear = established_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", established_year=" + establishedYear +
                '}';
    }
}

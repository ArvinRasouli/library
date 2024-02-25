package com.mupra.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private Date birthDate;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> bookList;

    public Author() {

    }

    public Author(String name, Date birth) {
        this.name = name;
        this.birthDate = birth;
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

    public Date getBirth() {
        return birthDate;
    }

    public void setBirth(Date birth) {
        this.birthDate = birth;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birthDate +
                '}';
    }

}

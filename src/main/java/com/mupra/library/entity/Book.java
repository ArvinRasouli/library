package com.mupra.library.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

//    @Size(max = 100, message = "Name length must be less than or equal to 100 characters")
    @Column(name = "name")
    private String name;

//    @Min(value = 0, message = "Print year must be greater then or equal to 0")
//    @Max(value = 1402, message = "Print year must be less than 1403")
    @Column(name = "print_year")
    private int printYear;

//    @Min(value = 0, message = "Print year must be greater then or equal to 0")
    @Column(name = "inventory")
    private int inventory;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book() {

    }

    public Book(String name, int print_year, int inventory) {
        this.name = name;
        this.printYear = print_year;
        this.inventory = inventory;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", print_year=" + printYear +
                ", inventory=" + inventory +
                '}';
    }
}

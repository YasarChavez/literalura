package com.yasarchavez.literalura.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int birthdate;
    private int deathdate;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }

    public Author(String name, int birthdate, int deathdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
    }

    public Author(AuthorRec autorRec) {
        this.name = autorRec.name();
        this.birthdate = autorRec.birthYear();
        this.deathdate = autorRec.deathYear();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public int getDeathdate() {
        return this.deathdate;
    }

    public void setDeathdate(int deathdate) {
        this.deathdate = deathdate;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", birthdate='" + getBirthdate() + "'" +
                ", deathdate='" + getDeathdate() + "'" +
                "}";
    }
}

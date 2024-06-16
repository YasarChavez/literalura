package com.yasarchavez.literalura.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    @JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    private List<String> translators;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;
    private boolean copyright;
    private String mediaType;
    private int downloadCount;

    public Book() {
    }

    public Book(int id, String title, List<Author> authors, List<String> translators, List<String> subjects,
            List<String> bookshelves, List<String> languages, boolean copyright, String mediaType, int downloadCount) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.translators = translators;
        this.subjects = subjects;
        this.bookshelves = bookshelves;
        this.languages = languages;
        this.copyright = copyright;
        this.mediaType = mediaType;
        this.downloadCount = downloadCount;
    }

    public Book(BookRec bookRec) {
        this.id = bookRec.id();
        this.title = bookRec.title();
        this.authors = new ArrayList<>();
        this.translators = bookRec.translators();
        this.subjects = bookRec.subjects();
        this.bookshelves = bookRec.bookshelves();
        this.languages = bookRec.languages();
        this.copyright = bookRec.copyright();
        this.mediaType = bookRec.mediaType();
        this.downloadCount = bookRec.downloadCount();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getTranslators() {
        return this.translators;
    }

    public void setTranslators(List<String> translators) {
        this.translators = translators;
    }

    public List<String> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getBookshelves() {
        return this.bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<String> getLanguages() {
        return this.languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public boolean isCopyright() {
        return this.copyright;
    }

    public boolean getCopyright() {
        return this.copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getDownloadCount() {
        return this.downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", authors='" + getAuthors() + "'" +
                ", translators='" + getTranslators() + "'" +
                ", subjects='" + getSubjects() + "'" +
                ", bookshelves='" + getBookshelves() + "'" +
                ", languages='" + getLanguages() + "'" +
                ", copyright='" + isCopyright() + "'" +
                ", mediaType='" + getMediaType() + "'" +
                ", downloadCount='" + getDownloadCount() + "'" +
                "}";
    }

}

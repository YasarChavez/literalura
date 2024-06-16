package com.yasarchavez.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookRec(
    @JsonAlias("id") int id,
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<AuthorRec> authors,
    @JsonAlias("translators") List<String> translators,
    @JsonAlias("subjects") List<String> subjects,
    @JsonAlias("bookshelves") List<String> bookshelves,
    @JsonAlias("languages") List<String> languages,
    @JsonAlias("copyright") boolean copyright,
    @JsonAlias("mediaType") String mediaType,
    @JsonAlias("download_count") int downloadCount) {
}

package com.zemoso.auth0.auth0sample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Book {
    private String authorName;
    private String description;

    public Book(String authorName, String description) {
        this.authorName = authorName;
        this.description = description;
    }
}
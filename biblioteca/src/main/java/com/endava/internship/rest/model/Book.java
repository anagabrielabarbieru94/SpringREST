package com.endava.internship.rest.model;

import java.util.StringTokenizer;

/**
 * Created by abarbieru on 7/15/2016.
 */
public class Book {

    private String ISBN;
    private String title;
    private String author;
    private Integer year;

    public Book(){

    }

    public Book(String isbn, String t, String a, Integer y){
        this.ISBN = isbn;
        this.title = t;
        this.author = a;
        this.year = y;
    }

    public void setISBN(String isbn){
        this.ISBN = isbn;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setTitle(String t){
        this.title = t;
    }

    public String getTitle(){
        return title;
    }

    public void setAuthor(String a){
        this.author = a;
    }

    public String getAuthor(){
        return author;
    }

    public void setYear(Integer y){
        this.year = y;
    }

    public Integer getYear(){
        return year;
    }
}

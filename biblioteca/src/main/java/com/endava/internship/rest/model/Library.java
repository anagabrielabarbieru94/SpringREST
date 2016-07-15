package com.endava.internship.rest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abarbieru on 7/15/2016.
 */
public class Library {

    private static int index = 0;
    private Integer libraryId = new Integer(0);
    private String name;
    private List<Book> bookList = new ArrayList<Book>();

    public Library(){

    }

    public Library(String n){
        this.name = n;
        ++index;
        this.libraryId = index;
    }

    public void setLibraryId(){
        ++index;
        this.libraryId = index;
    }

    public Integer getId(){
        return libraryId;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }

    public void setBookList(List <Book> books){
        this.bookList = books;
    }

    public List<Book> getBookList(){
        return bookList;
    }
}

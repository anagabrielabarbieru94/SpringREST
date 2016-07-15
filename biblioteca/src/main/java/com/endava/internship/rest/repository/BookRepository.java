package com.endava.internship.rest.repository;

import com.endava.internship.rest.model.Book;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abarbieru on 7/15/2016.
 */
@Repository
public class BookRepository {

    List<Book>books = new ArrayList<Book>();

    @PostConstruct
    public void initializeBookRepo(){
        Book book1 = new Book("123-450", "Ion", "Liviu Rebreanu", 1980);
        Book book2 = new Book("1234-451", "Ultima noapte de dragoste, intaia noapte de razboi", "Camil Petrescu", 1996);
        Book book3 = new Book("123-452", "Alchimistul", "Paulo Coelho", 2004);

        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

}

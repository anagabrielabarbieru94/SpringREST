package com.endava.internship.rest.repository;

import com.endava.internship.rest.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abarbieru on 7/15/2016.
 */
@Repository
public class LibraryRepository {

    private List<Library> libraries = new ArrayList<Library>();
    @Autowired
    private BookRepository bookRepo;

    @PostConstruct
    public void initializeLibRepo(){
        Library lib = new Library("Lib1");
        lib.setBookList(bookRepo.books);
        Library lib2 = new Library("Lib2");
        lib.setBookList(bookRepo.books);
        libraries.add(lib);
        libraries.add(lib2);
    }

    public List<Library> getLibraries(){
        return libraries;
    }
}

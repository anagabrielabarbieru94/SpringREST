package com.endava.internship.rest.service;

import com.endava.internship.rest.model.Library;
import com.endava.internship.rest.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abarbieru on 7/15/2016.
 */
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libRepo;

    public List<Library> getLibraries(){
        return libRepo.getLibraries();
    }

    public Library getLibrary(Integer id){
        return new Library("Lib"+id);
    }


}

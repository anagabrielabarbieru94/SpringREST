package com.endava.internship.rest.controller;

import com.endava.internship.rest.model.Library;
import com.endava.internship.rest.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by abarbieru on 7/15/2016.
 */
@RestController
@RequestMapping(path = "/libraries", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryController {

    @Autowired
    private LibraryService libService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resources<Resource<Library>>> getLibraries() {
        List<Library> libraries = this.libService.getLibraries();

        //System.out.println(libraries.get(0).getBookList().get(0).getAuthor());

        Resources<Resource<Library>> libraryResources = Resources.wrap(libraries);

        libraryResources.add(linkTo(methodOn(LibraryController.class).getLibraries()).withRel("custom-self"));


        /*artistResources.forEach((artistResource -> {
            artistResource.add(linkTo(methodOn(ArtistsController.class)
                    .getArtist(artistResource.getContent().getId())).withRel("custom-self"));
        }));*/

        libraryResources.forEach((libraryResource -> {
            libraryResource.add(linkTo(methodOn(LibraryController.class)
                    .getLibrary(libraryResource.getContent().getId())).withRel("custom-self"));
        }));

        return new ResponseEntity<>(libraryResources, HttpStatus.OK);
    }

    @RequestMapping(path = "/{libraryId}", method = RequestMethod.GET)
    public HttpEntity<Resource<Library>> getLibrary(@PathVariable Integer libraryId) {
        Library lib = this.libService.getLibrary(libraryId);

        Resource<Library> libraryResource = new Resource<>(lib);
        libraryResource.add(linkTo(methodOn(LibraryController.class).getLibrary(libraryId)).withRel("another-self"));

        return new ResponseEntity<>(libraryResource, HttpStatus.OK);
    }

}

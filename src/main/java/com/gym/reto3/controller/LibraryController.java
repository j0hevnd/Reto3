package com.gym.reto3.controller;

import com.gym.reto3.entities.Library;
import com.gym.reto3.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/all")
    public List<Library> getAll(){
        return libraryService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody  Library l){
        libraryService.save(l);
    }
}

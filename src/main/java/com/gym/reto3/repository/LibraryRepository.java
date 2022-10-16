package com.gym.reto3.repository;

import com.gym.reto3.entities.Library;
import com.gym.reto3.repository.crudrepository.LibraryCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository {
    @Autowired
    private LibraryCrudRepository libraryCrudRepository;

    public List<Library> getAll(){
        return (List<Library>) libraryCrudRepository.findAll();
    }

    public Optional<Library> getLibrary(int id){
        return libraryCrudRepository.findById(id);
    }

    public Library save(Library l){
        return libraryCrudRepository.save(l);
    }

    public void delete(Library l){
        libraryCrudRepository.delete(l);
    }
}

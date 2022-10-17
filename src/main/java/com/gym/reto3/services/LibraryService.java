package com.gym.reto3.services;

import com.gym.reto3.entities.Client;
import com.gym.reto3.entities.Library;
import com.gym.reto3.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAll() {
        return libraryRepository.getAll();
    }

    public Optional<Library> getLibraryById(int id) {
        return libraryRepository.getLibrary(id);
    }

    public Library save(Library c) {
        if (c.getId() == null) {
            return libraryRepository.save(c);
        } else {
            Optional<Library> lib = libraryRepository.getLibrary(c.getId());
            if (lib.isPresent()) {
                return c;
            } else {
                return libraryRepository.save(c);
            }
        }
    }

    public Library update(Library c) {
        Optional<Library> LibraryServer = libraryRepository.getLibrary(c.getId());
        if (LibraryServer.isPresent() && c.getId() != null && c.getName() != null) {
            LibraryServer.get().setName(c.getName());
            LibraryServer.get().setTarget(c.getTarget());
            LibraryServer.get().setDescription(c.getDescription());
            return libraryRepository.save(LibraryServer.get());
        }
        return c;
    }

    public Boolean delete(int id){
        Optional<Library> LibraryId = libraryRepository.getLibrary(id);
        if (LibraryId.isPresent()) {
            libraryRepository.delete(LibraryId.get());
            return true;
        }
        return false;
    }
}

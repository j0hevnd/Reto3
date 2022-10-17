package com.gym.reto3.repository;

import com.gym.reto3.entities.Category;
import com.gym.reto3.repository.crudrepository.CategoryCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(Integer id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }

    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }

    public void deleteAll() {
        categoryCrudRepository.deleteAll();
    }
}

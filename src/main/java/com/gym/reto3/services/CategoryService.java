package com.gym.reto3.services;

import com.gym.reto3.entities.Category;
import com.gym.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

     public List<Category> getAll() {
         return categoryRepository.getAll();
     }

     public Optional<Category> getCategoryById(Integer id) {
         return categoryRepository.getCategory(id);
     }

     public Category save(Category c) {
         if (c.getcategoryId() == null) {
             return categoryRepository.save(c);
         } else {
            Optional<Category> cat = categoryRepository.getCategory(c.getcategoryId());
             if (cat.isPresent()) {
                 return c;
             } else {
                return categoryRepository.save(c);
             }
         }
     }

     public Category update(Category c) {
         Optional<Category> categoryServer = categoryRepository.getCategory(c.getcategoryId());
         if (categoryServer.isPresent() && c.getcategoryId() != null && c.getName() != null) {
            categoryServer.get().setName(c.getName());
            categoryServer.get().setDescription(c.getDescription());
            return categoryRepository.save(categoryServer.get());
         }
         return c;
     }

     public Boolean delete(int id){
         Optional<Category> categoryId = categoryRepository.getCategory(id);
         if (categoryId.isPresent()) {
                categoryRepository.delete(categoryId.get());
                return true;
         }
         return false;
     }

     public void deleteAll() {
         categoryRepository.deleteAll();
     }

}

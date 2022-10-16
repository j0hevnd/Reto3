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

     public Optional<Category> getCategoryById(int id) {
         return categoryRepository.getCategory(id);
     }

     public Category save(Category c) {
         Optional<Category> cat = categoryRepository.getCategory(c.getId());
         if (c.getId() == null || cat.isEmpty()) {
             return categoryRepository.save(c);
         }
         return c;
     }

     public Category update(Category c) {
         Optional<Category> categoryServer = categoryRepository.getCategory(c.getId());
         if (categoryServer.isPresent() && c.getId() != null && c.getName() != null) {
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

}

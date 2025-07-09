package org.example.book.dalti_back.service;

import org.example.book.dalti_back.entity.Category;
import org.example.book.dalti_back.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public Category insert(Category category) {
        return categoryRepo.save(category);
    }

    public Category update(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }

    public List<org.example.book.dalti_back.entity.Service> getServicesByCategoryId(Long id) {
        List<org.example.book.dalti_back.entity.Service> services
                = new ArrayList<>(categoryRepo.findById(id).orElseThrow().getServices());
        services.sort(Comparator.comparing(org.example.book.dalti_back.entity.Service::getId)); // Sort by name (ascending)
        return services;
    }


}

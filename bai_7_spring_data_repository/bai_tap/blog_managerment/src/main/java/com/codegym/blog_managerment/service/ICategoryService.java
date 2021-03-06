package com.codegym.blog_managerment.service;

import com.codegym.blog_managerment.model.Blog;
import com.codegym.blog_managerment.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    void saveCategory(Category category);
    void deleteCategory(int id);
    Category findCategoryById(int id);
}
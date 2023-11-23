package com.WIKI.dev.category.service;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> queryCategoryList() {
        List<Category> categoryList = categoryRepository.findByCategoryName();
        return categoryList;
    }
}

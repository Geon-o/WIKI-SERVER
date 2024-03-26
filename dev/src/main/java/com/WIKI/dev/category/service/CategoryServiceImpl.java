package com.WIKI.dev.category.service;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.entity.SubCategory;
import com.WIKI.dev.category.repository.CategoryRepository;
import com.WIKI.dev.category.repository.SubCategoryRepository;
import com.WIKI.dev.category.service.dto.request.EditCategoryRequest;
import com.WIKI.dev.category.service.dto.request.RegisterCategoryRequest;
import com.WIKI.dev.category.service.dto.request.RegisterSubCategoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public List<Category> queryCategoryList() {
        List<Category> categoryList = categoryRepository.findCategoryWithSubCategories();

        return categoryList;
    }

    @Override
    @Transactional
    public void register(RegisterCategoryRequest registerCategoryRequest) {
        String categoryName = registerCategoryRequest.getCategoryName();

        Category category = new Category();
        category.setName(categoryName);

        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void registerSubCategory(RegisterSubCategoryRequest request) {
        Long categoryId = request.getCategoryId();

        SubCategory subCategory = new SubCategory();
        Category category;

        Optional<Category> maybeCategory = categoryRepository.findById(categoryId);

        try{
            if (maybeCategory.isPresent()) {
                category = maybeCategory.get();

                subCategory.setSubCategoryTitle(request.getSubCategoryTitle());
                subCategory.setCategory(category);

            }

            subCategoryRepository.save(subCategory);

        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }

    @Override
    @Transactional
    public void edit(EditCategoryRequest request) {
        Optional<Category> maybeCategory = categoryRepository.findById(request.getId());

        if (maybeCategory.isPresent()) {
            Category category = maybeCategory.get();

            category.setName(request.getCategoryName());

            categoryRepository.save(category);
        }
    }
}

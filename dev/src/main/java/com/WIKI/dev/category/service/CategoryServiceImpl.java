package com.WIKI.dev.category.service;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.entity.SubCategory;
import com.WIKI.dev.category.repository.CategoryRepository;
import com.WIKI.dev.category.repository.SubCategoryRepository;
import com.WIKI.dev.category.service.dto.request.RegisterCategoryRequest;
import com.WIKI.dev.category.service.dto.request.RegisterSubCategoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Category> categoryList = categoryRepository.findCategoryByIdAndAndSubCategory();

        return categoryList;
    }

    @Override
    public void register(RegisterCategoryRequest registerCategoryRequest) {
        String categoryName = registerCategoryRequest.getCategoryName();

        Category category = new Category();
        category.setName(categoryName);

        categoryRepository.save(category);
    }

    @Override
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
}

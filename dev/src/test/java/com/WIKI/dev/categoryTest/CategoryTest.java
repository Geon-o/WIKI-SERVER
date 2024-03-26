package com.WIKI.dev.categoryTest;


import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.entity.SubCategory;
import com.WIKI.dev.category.repository.CategoryRepository;
import com.WIKI.dev.category.service.CategoryService;
import com.WIKI.dev.category.service.dto.request.EditCategoryRequest;
import com.WIKI.dev.category.service.dto.request.RegisterCategoryRequest;
import com.WIKI.dev.category.service.dto.request.RegisterSubCategoryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryTest {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryTest(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;

    }

    /**
     * 등록된 카테고리 목록 가져오기 테스트
     */
    @Test
    void selectCategoryList() {

        /**
         * 서비스 로직 자체 검증
         */
        System.out.println(categoryRepository.findCategoryWithSubCategories());
    }
    /**
     * 카테고리 등록하기 테스트
     */
    @Test
    void registerCategory() {
        RegisterCategoryRequest categoryRequest = new RegisterCategoryRequest("새로운 카테고리 3");

        Category category = new Category();
        category.setName(categoryRequest.getCategoryName());

        categoryRepository.save(category);
    }

    @Test
    void registerSubCategory() {
        RegisterSubCategoryRequest request = new RegisterSubCategoryRequest(7L, "");

        categoryService.registerSubCategory(request);
    }

    @Test
    void edit() {
        EditCategoryRequest request = new EditCategoryRequest(1L, "수정카테고리");

        categoryService.edit(request);

    }
}

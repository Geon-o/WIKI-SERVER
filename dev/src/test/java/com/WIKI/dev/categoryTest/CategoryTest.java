package com.WIKI.dev.categoryTest;


import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.repository.CategoryRepository;
import com.WIKI.dev.category.service.CategoryService;
import com.WIKI.dev.category.service.dto.request.RegisterCategoryRequest;
import com.WIKI.dev.category.service.dto.request.RegisterSubCategoryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

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
        List<Category> categoryList = categoryRepository.findAll();

        System.out.println(categoryList);


        /**
         * 서비스 함수 호출
         */
//        System.out.println(categoryService.queryCategoryList());
    }

    /**
     * 카테고리 등록하기 테스트
     */
    @Test
    void registerCategory() {
        RegisterCategoryRequest categoryRequest = new RegisterCategoryRequest("테스트 카테고리");

        Category category = new Category();
        category.setName(categoryRequest.getCategoryName());

        categoryRepository.save(category);
    }

    @Test
    void registerSubCategory() {
        RegisterSubCategoryRequest request = new RegisterSubCategoryRequest(1L, "서브 카테고리3");

        categoryService.registerSubCategory(request);
    }
}

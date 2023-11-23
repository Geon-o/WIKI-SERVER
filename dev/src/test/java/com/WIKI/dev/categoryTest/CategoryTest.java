package com.WIKI.dev.categoryTest;


import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.repository.CategoryRepository;
import com.WIKI.dev.category.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void selectCategoryList() {

        /**
         * 서비스 로직 자체 검증
         */
//        List<Category> categoryList = categoryRepository.findByCategoryName();
//
//        System.out.println(categoryList);


        /**
         * 서비스 함수 호출
         */
        System.out.println(categoryService.queryCategoryList());
    }
}

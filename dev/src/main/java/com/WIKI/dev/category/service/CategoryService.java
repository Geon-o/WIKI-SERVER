package com.WIKI.dev.category.service;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.service.dto.request.RegisterCategoryRequest;
import com.WIKI.dev.category.service.dto.request.RegisterSubCategoryRequest;

import java.util.List;


public interface CategoryService {

    List<Category> queryCategoryList();
    void register(RegisterCategoryRequest registerCategoryRequest);
    void registerSubCategory(RegisterSubCategoryRequest request);
}

package com.WIKI.dev.category.repository;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

}

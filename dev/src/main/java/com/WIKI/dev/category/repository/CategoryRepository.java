package com.WIKI.dev.category.repository;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c left join fetch c.subCategory")
    List<Category> findCategoryWithSubCategories();

}

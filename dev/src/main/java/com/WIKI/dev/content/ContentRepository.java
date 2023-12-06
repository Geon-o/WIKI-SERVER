package com.WIKI.dev.content;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.content.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query("select c from Content c join fetch c.category cg where cg.id = :categoryId")
    List<Content> findContentListByCategory(@Param("categoryId") Long categoryId);
}

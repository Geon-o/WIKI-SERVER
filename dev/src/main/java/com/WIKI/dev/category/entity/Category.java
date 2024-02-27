package com.WIKI.dev.category.entity;

import com.WIKI.dev.content.entity.Content;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<SubCategory> subCategory;
}

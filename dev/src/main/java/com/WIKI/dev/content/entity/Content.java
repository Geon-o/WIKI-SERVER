package com.WIKI.dev.content.entity;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.entity.SubCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String contents;

    @CreationTimestamp
    private Date reaDate;

    @UpdateTimestamp
    private Date upDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "subCategory_id")
//    private SubCategory subCategory;
}

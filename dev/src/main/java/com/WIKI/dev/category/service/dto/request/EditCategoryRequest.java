package com.WIKI.dev.category.service.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditCategoryRequest {

    private long id;
    private String categoryName;

}

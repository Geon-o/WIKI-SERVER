package com.WIKI.dev.category.service.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RegisterSubCategoryRequest {

    private final Long categoryId;
    private final String subCategoryTitle;

}

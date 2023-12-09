package com.WIKI.dev.content.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ContentManagementRequest {

    private final Long categoryId;
    private final Long contentId;
    private final String title;
    private final String content;

}

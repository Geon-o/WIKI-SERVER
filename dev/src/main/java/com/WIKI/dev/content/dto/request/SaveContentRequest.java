package com.WIKI.dev.content.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SaveContentRequest {

    private final Long categoryId;
    private final String title;
    private final String content;
}

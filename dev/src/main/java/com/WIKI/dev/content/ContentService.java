package com.WIKI.dev.content;

import com.WIKI.dev.content.dto.request.SaveContentRequest;

public interface ContentService {

    public boolean saveContent(SaveContentRequest saveContentRequest);
}

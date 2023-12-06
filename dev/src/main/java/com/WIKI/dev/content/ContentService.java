package com.WIKI.dev.content;

import com.WIKI.dev.content.dto.request.ContentListRequest;
import com.WIKI.dev.content.dto.request.SaveContentRequest;
import com.WIKI.dev.content.entity.Content;

import java.util.List;

public interface ContentService {

    public boolean saveContent(SaveContentRequest saveContentRequest);

    public List<Content> getContentByCategory(ContentListRequest contentListRequest);
}

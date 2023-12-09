package com.WIKI.dev.content;

import com.WIKI.dev.content.dto.request.ContentListRequest;
import com.WIKI.dev.content.dto.request.ContentManagementRequest;
import com.WIKI.dev.content.entity.Content;

import java.util.List;

public interface ContentService {

    public boolean saveContent(ContentManagementRequest contentManagementRequest);

    public List<Content> getContentByCategory(ContentListRequest contentListRequest);

    public Boolean modifyContent(ContentManagementRequest contentManagementRequest);
}

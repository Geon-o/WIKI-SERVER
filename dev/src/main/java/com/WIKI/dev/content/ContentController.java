package com.WIKI.dev.content;


import com.WIKI.dev.content.dto.request.ContentListRequest;
import com.WIKI.dev.content.dto.request.ContentManagementRequest;
import com.WIKI.dev.content.dto.request.SaveContentRequest;
import com.WIKI.dev.content.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/save")
    public Boolean saveContent(@RequestBody SaveContentRequest saveContentRequest) {
        return contentService.saveContent(saveContentRequest);
    }

    @PostMapping("/list")
    public List<Content> contentList(@RequestBody ContentListRequest contentListRequest){
        return contentService.getContentByCategory(contentListRequest);
    }

    @PostMapping("/modify")
    public Boolean modifyContent(@RequestBody ContentManagementRequest contentManagementRequest) {
        return contentService.modifyContent(contentManagementRequest);
    }

    @PostMapping("/delete")
    public boolean deleteContent(@RequestBody ContentManagementRequest contentManagementRequest) {
        return contentService.deleteContent(contentManagementRequest.getContentId());
    }
}

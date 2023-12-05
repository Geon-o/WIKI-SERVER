package com.WIKI.dev.content;


import com.WIKI.dev.content.dto.request.SaveContentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

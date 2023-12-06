package com.WIKI.dev.contentTest;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.repository.CategoryRepository;
import com.WIKI.dev.content.ContentRepository;
import com.WIKI.dev.content.ContentService;
import com.WIKI.dev.content.dto.request.ContentListRequest;
import com.WIKI.dev.content.dto.request.SaveContentRequest;
import com.WIKI.dev.content.entity.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ContentTest {

    private final ContentRepository contentRepository;
    private final CategoryRepository categoryRepository;

    private final ContentService contentService;

    @Autowired
    public ContentTest(ContentRepository contentRepository, CategoryRepository categoryRepository, ContentService contentService) {
        this.contentRepository = contentRepository;
        this.categoryRepository = categoryRepository;
        this.contentService = contentService;
    }

    @Test
    void saveContent() {
        SaveContentRequest saveContentRequest = new SaveContentRequest(1l, "제목2", "내용3");

        System.out.println(contentService.saveContent(saveContentRequest));

//        Content content = new Content();
//        content.setContents(saveContentRequest.getContent());
//        content.setTitle(saveContentRequest.getTitle());
//
//        Optional<Category> category = categoryRepository.findById(saveContentRequest.getCategoryId());
//
//        if (category.isPresent()) {
//            content.setCategory(category.get());
//        }
//
//
//        contentRepository.save(content);
    }

    @Test
    void ContentLIstByCategory() {
        ContentListRequest contentListRequest = new ContentListRequest(1l);

        List<Content> contentList = contentService.getContentByCategory(contentListRequest);

        for (int i = 0; i < contentList.size(); i++) {
            System.out.println("확인" + i + " : " + contentList.get(i).getTitle().toString());
        }
    }
}

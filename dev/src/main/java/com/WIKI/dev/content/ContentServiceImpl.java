package com.WIKI.dev.content;

import com.WIKI.dev.category.entity.Category;
import com.WIKI.dev.category.repository.CategoryRepository;
import com.WIKI.dev.content.dto.request.ContentListRequest;
import com.WIKI.dev.content.dto.request.SaveContentRequest;
import com.WIKI.dev.content.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository, CategoryRepository categoryRepository) {
        this.contentRepository = contentRepository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * 게시글 저장 로직
     * @param saveContentRequest
     * @return
     */
    @Override
    public boolean saveContent(SaveContentRequest saveContentRequest) {
        Content content = new Content();
        Category category;

        Optional<Category> maybeCategory = categoryRepository.findById(saveContentRequest.getCategoryId());

        if (maybeCategory.isPresent()) {
            category = maybeCategory.get();
        } else {
            return false;
        }

        content.setTitle(saveContentRequest.getTitle());
        content.setContents(saveContentRequest.getContent());
        content.setCategory(category);

        contentRepository.save(content);

        return true;
    }

    @Override
    public List<Content> getContentByCategory(ContentListRequest contentListRequest) {
        Long categoryId = contentListRequest.getCategoryId();
        return contentRepository.findContentListByCategory(categoryId);
    }
}

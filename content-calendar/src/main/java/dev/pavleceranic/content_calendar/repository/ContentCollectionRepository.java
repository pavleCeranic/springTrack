package dev.pavleceranic.content_calendar.repository;

import dev.pavleceranic.content_calendar.model.Content;
import dev.pavleceranic.content_calendar.model.Status;
import dev.pavleceranic.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c-> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
                 1,
                "My Content",
                 "About this Content",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                 null,
                 ""
        );

        contentList.add(c);
    }

    public void save(Content content) {
        contentList.removeIf(c-> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c-> c.id().equals(id));
    }
}

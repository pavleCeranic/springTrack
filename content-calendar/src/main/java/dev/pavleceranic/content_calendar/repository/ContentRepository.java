package dev.pavleceranic.content_calendar.repository;

import dev.pavleceranic.content_calendar.model.Content;
import dev.pavleceranic.content_calendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    // Example of query derivation check documention
    @Query("""
            SELECT * FROM Content WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}

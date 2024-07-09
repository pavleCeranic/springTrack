package dev.pavleceranic.content_calendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.pavleceranic.content_calendar.model.Content;
import dev.pavleceranic.content_calendar.model.Type;
import dev.pavleceranic.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner{

    private final ContentRepository contentRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository contentRepository, ObjectMapper objectMapper) {
        this.contentRepository = contentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {

            contentRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {}));

        }

//    System.out.println("Hello!");
    }
}

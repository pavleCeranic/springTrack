package dev.pavleceranic.content_calendar.controller;

import dev.pavleceranic.content_calendar.model.Content;
import dev.pavleceranic.content_calendar.model.Status;
import dev.pavleceranic.content_calendar.repository.ContentCollectionRepository;
//import dev.pavleceranic.content_calendar.repository.ContentJdbcTemplateRepository;
import dev.pavleceranic.content_calendar.repository.ContentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

//    private final ContentJdbcTemplateRepository repository;
    @GetMapping("")
    public List<Content> findAll()  {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }


    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<Content> listByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }

}

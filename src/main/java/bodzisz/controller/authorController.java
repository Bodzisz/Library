package bodzisz.controller;

import bodzisz.model.Author;
import bodzisz.repository.authorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class authorController {
    private final Logger logger = LoggerFactory.getLogger(bookController.class);
    private authorRepository repository;

    public authorController(authorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Author>> findAll() {
        logger.info("Got request for all Authors");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Author> findById(@PathVariable Integer id) {
        logger.info("Got request for Author with Id: " + id);
        return ResponseEntity.ok(repository.findById(id).orElse(null));
    }
}

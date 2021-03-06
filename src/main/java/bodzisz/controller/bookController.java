package bodzisz.controller;

import bodzisz.model.Book;
import bodzisz.repository.bookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {
    private bookRepository repository;
    private final Logger logger = LoggerFactory.getLogger(bookController.class);

    public bookController(bookRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> findAll() {
        logger.info("Got request for all Books");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        logger.info("Got request for book with Id: " + id);
        return ResponseEntity.ok(repository.findById(id).orElse(null));
    }
}

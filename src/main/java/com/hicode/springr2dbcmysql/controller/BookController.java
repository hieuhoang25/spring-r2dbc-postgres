package com.hicode.springr2dbcmysql.controller;

import com.hicode.springr2dbcmysql.model.Book;
import com.hicode.springr2dbcmysql.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class BookController {
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<Flux<Book>> getAllBook(@RequestParam(required = false) Optional<String> optTitle){
        if (optTitle.isPresent()){
            return ResponseEntity.ok(bookService.findByTitle(optTitle.get()));
        }
        return ResponseEntity.ok(bookService.findAll());
    }
    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Book> getBookById(@PathVariable("id") int id){
         return bookService.findById(id);
    }
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> createTutorial(@RequestBody Book book){
        return bookService.save(book);
    }
    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Book> updateTutorial(@PathVariable("id") int id, @RequestBody Book book) {
        return bookService.update(id, book);
    }
    @DeleteMapping("/tutorials/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTutorial(@PathVariable("id") int id) {
        return bookService.deleteById(id);
    }

    @DeleteMapping("/tutorials")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllTutorials() {
        return bookService.deleteAll();
    }

    @GetMapping("/tutorials/published")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Book> findByPublished() {
        return bookService.findByPublished(true);
    }
}

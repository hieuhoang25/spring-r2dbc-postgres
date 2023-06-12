package com.hicode.springr2dbcmysql.service;

import com.hicode.springr2dbcmysql.model.Book;
import com.hicode.springr2dbcmysql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public Flux<Book> findAll(){
      return  bookRepository.findAll();
    }

    public Flux<Book> findByTitle(String title){
        return bookRepository.findByTitleContaining(title);
    }
    public Mono<Book> findById(int id){
        return bookRepository.findById(id);
    }
    public Mono<Book> save(Book book){
        return bookRepository.save(book);
    }
    public Mono<Book> update(int id, Book book){
         return bookRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                 .flatMap(optionalTutorial -> {
                     if (optionalTutorial.isPresent()){
                         book.setId(id);
                         return bookRepository.save(book);
                     }
                     return Mono.empty();
                 });
    }
    public Mono<Void> deleteById(int id){
        return bookRepository.deleteById(id);
    }
    public Mono<Void> deleteAll(){
        return bookRepository.deleteAll();
    }
    public Flux<Book> findByPublished(boolean isPublished){
        return bookRepository.findByPublished(isPublished);
    }
}

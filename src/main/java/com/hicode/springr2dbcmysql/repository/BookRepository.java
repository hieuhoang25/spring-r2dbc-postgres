package com.hicode.springr2dbcmysql.repository;

import com.hicode.springr2dbcmysql.model.Book;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends R2dbcRepository<Book, Integer> {
    Flux<Book> findByTitleContaining(String title);

    Flux<Book> findByPublished(boolean isPublished);

}

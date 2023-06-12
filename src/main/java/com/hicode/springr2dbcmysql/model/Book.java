package com.hicode.springr2dbcmysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

//@Entity : unavailable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @Id
    private int id;
    private String title;

    private String description;

    private boolean published;


}

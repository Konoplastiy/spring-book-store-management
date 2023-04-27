package com.konoplastiy.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="MyBooks")
public class MyBookList {

    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}

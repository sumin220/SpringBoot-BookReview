package example.review.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<ReviewBook> reviews = new ArrayList<>();

    private String title; // name

    private String author;

    private int price;

    private String isbn;
}

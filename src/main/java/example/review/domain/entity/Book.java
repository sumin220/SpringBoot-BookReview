package example.review.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private final List<ReviewBook> reviews = new ArrayList<>();

    private String title; // name

    private String author;

    private int price;

    private String isbn;
}

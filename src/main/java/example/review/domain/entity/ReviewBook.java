package example.review.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Table(name = "review_book")
public class ReviewBook {

    @Id
    @GeneratedValue
    @Column(name = "review_book_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book; //리뷰 할 책

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "review_id")
    private Review review; //리뷰
}

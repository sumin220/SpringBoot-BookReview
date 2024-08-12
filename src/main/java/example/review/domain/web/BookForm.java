package example.review.domain.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {
    private Long id;
    private String title;
    private int price;
    private String author;
    private String isbn;
}

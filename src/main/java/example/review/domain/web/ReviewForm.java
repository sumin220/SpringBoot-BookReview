package example.review.domain.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewForm {

    private Long id;

    private String name;

    private String content;
}

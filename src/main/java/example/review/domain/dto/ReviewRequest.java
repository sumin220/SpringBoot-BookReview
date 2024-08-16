package example.review.domain.dto;

import example.review.domain.entity.Review;

import java.time.LocalDate;

public record ReviewRequest(
        String title,
        String content,
        String author,
        LocalDate reviewDate
) {
    public Review toEntity() { //빌더타입
        return Review.builder()
                .title(title)
                .author(author)
                .content(content)
                .reviewDate(reviewDate)
                .build();
    }
}

package example.review.domain.service;

import example.review.domain.entity.Book;
import example.review.domain.entity.Member;
import example.review.domain.entity.Review;
import example.review.domain.repository.BookRepository;
import example.review.domain.repository.MemberRepository;
import example.review.domain.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    /**
     * 리뷰
     */
    @Transactional
    public Long review(Long memberId, Long bookId, String content) {
        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Book book = bookRepository.findOne(bookId);

        // 리뷰 생성
        Review review = Review.builder()
                .member(member) // 리뷰 작성자 설정
                .content(content) // 내용 설정
                .reviewDate(LocalDate.now()) // 현재 날짜로 리뷰 날짜 설정
                .build();

        // 리뷰 저장
        reviewRepository.save(review);
        return review.getId();
    }

    /**
     * 리뷰 검색
     */
    public List<Review> findReviews() {
        return reviewRepository.findAll();
    }
}

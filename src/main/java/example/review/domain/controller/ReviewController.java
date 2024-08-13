package example.review.domain.controller;

import example.review.domain.entity.Book;
import example.review.domain.entity.Member;
import example.review.domain.entity.Review;
import example.review.domain.service.BookService;
import example.review.domain.service.MemberService;
import example.review.domain.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final BookService bookService;
    private final MemberService memberService;

    @GetMapping("/new")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Book> books = bookService.findBooks();

        model.addAttribute("members", members);
        model.addAttribute("books", books);

        return "review/reviewForm";
    }

    @PostMapping("/new")//리뷰생성
    public String review(@RequestParam("memberId") Long memberId,
                         @RequestParam("bookId") Long bookId,
                         @RequestParam("content") String content) {
        reviewService.review(memberId, bookId, content);
        return "redirect:/";
    }

    @GetMapping//조회
    public String list(Model model) {
        List<Review> reviews = reviewService.findReviews();
        model.addAttribute("reviews", reviews);
        return "review/reviewList";
    }
}

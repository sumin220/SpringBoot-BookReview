package example.review.domain.controller;

import example.review.domain.entity.Book;
import example.review.domain.entity.Member;
import example.review.domain.repository.ReviewRepository;
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

    @GetMapping
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Book> books = bookService.findBooks();

        model.addAttribute("members", members);
        model.addAttribute("books", books);

        return "review/reviewForm";
    }

    @PostMapping
    public String review(@RequestParam("memberId") Long memberId,
                         @RequestParam("bookId") Long bookId,
                         @RequestParam("content") String content) {
        reviewService.review(memberId, bookId, content);
        return "redirect:/review";
    }
}

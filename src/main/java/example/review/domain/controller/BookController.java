package example.review.domain.controller;

import example.review.domain.dto.BookRequest;
import example.review.domain.entity.Book;
import example.review.domain.service.BookService;
import example.review.domain.web.BookForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "books/createBookForm";
    }

    @PostMapping(value = "/new")
    public String createBook(@Valid BookForm bookForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/createBookForm";
        }

        BookRequest bookRequest = new BookRequest
                (bookForm.getTitle(), bookForm.getAuthor(),
                        bookForm.getIsbn(), bookForm.getPrice());

        bookService.saveBook(bookRequest);

        return "redirect:/books";
    }

    @GetMapping
    public String list(Model model) {
        List<Book> books = bookService.findBooks();
        model.addAttribute("books", books);
        return "books/bookList";
    }
}

package example.review.domain.service;

import example.review.domain.dto.BookRequest;
import example.review.domain.entity.Book;
import example.review.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void saveBook(BookRequest bookRequest) {
        Book book = bookRequest.toEntity();
        bookRepository.save(book);
    }

    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    public Book findOne(Long bookId) {
        return bookRepository.findOne(bookId);
    }
}

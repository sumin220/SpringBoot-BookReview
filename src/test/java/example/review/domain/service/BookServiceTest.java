package example.review.domain.service;

import example.review.domain.entity.Book;
import example.review.domain.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void 책_등록() throws Exception {

        //given
        Book book = Book.builder()
                .title("무당이 키우기")
                .author("kim")
                .price(10000)
                .isbn("123-456")
                .build();

        //when
//        bookService.saveBook(book);
//        Long bookId = book.getId();
//        Book findBook = bookRepository.findOne(bookId);
        //then
//        assertThat(findBook).isNotNull();
//        assertThat(findBook.getTitle()).isEqualTo("무당이 키우기");
    }

}
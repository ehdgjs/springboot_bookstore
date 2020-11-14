package com.project.bookstore.service;

import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.book.BookRepository;
import com.project.bookstore.domain.cart.CartRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.books.dto.BookDeleteDto;
import com.project.bookstore.web.books.dto.BookSaveDto;
import com.project.bookstore.web.books.dto.BookUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CartRepository cartRepository;
    private final UsersInfo usersInfo;

    @Transactional
    public String saveBook(BookSaveDto bookSaveDto){
        return bookRepository.save(bookSaveDto.toEntity()).toString();
    }

    @Transactional(readOnly = true)
    public List<Book> findAllBook(){
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findBookById(Long bookUid){
        return bookRepository.findById(bookUid).get();
    }

    @Transactional
    public String updateBook(BookUpdateDto bookUpdateDto){
         return bookRepository.save(bookUpdateDto.toEntity()).toString();
    }

    @Transactional
    public void deleteBook(Long uid){
        bookRepository.delete(findBookById(uid));
    }
}

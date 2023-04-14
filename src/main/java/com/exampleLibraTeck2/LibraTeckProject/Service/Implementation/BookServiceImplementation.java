package com.exampleLibraTeck2.LibraTeckProject.Service.Implementation;

import com.exampleLibraTeck2.LibraTeckProject.Convertor.BookConvertor;
import com.exampleLibraTeck2.LibraTeckProject.Model.Author;
import com.exampleLibraTeck2.LibraTeckProject.Model.Book;
import com.exampleLibraTeck2.LibraTeckProject.Repository.AuthorRepository;
import com.exampleLibraTeck2.LibraTeckProject.Repository.BookRepository;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.BookAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.BookAddResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplementation implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public BookAddResponseDto addBook(BookAddRequestDto bookAddRequestDto){
        Author author = authorRepository.findById(bookAddRequestDto.getAuthorId()).get();

        Book book = new Book();
        book.setTitle(bookAddRequestDto.getTitle());
        book.setGenere(bookAddRequestDto.getGenere());
        book.setPrice(bookAddRequestDto.getPrice());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBookList().add(book);
        authorRepository.save(author);  // will save both book and author

        // create a response also
        BookAddResponseDto bookResponseDto = new BookAddResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());

        return bookResponseDto;

//        Author author = authorRepository.findById(bookAddRequestDto.getAuthorId()).get();
//
//        Book book= BookConvertor.BookAddRequestDtoToBook(bookAddRequestDto);
//        book.setAuthor(author);
//
//        author.getBookList().add(book);
//        authorRepository.save(author);
//
//        BookAddResponseDto bookAddResponseDto= BookConvertor.BookToBookAddResponse(book);
//
//        return bookAddResponseDto;

    }
    public BookAddResponseDto getAuthorByTitle(String title){
        Book book = bookRepository.findByTitle(title);

        BookAddResponseDto bookAddResponseDto = BookAddResponseDto.builder()
                .title(book.getTitle())
                .price(book.getPrice())
                .build();
        return bookAddResponseDto;
    }
}

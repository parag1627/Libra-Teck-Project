package com.exampleLibraTeck2.LibraTeckProject.Convertor;

import com.exampleLibraTeck2.LibraTeckProject.Model.Book;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.BookAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.BookAddResponseDto;

public class BookConvertor {

    public static Book BookAddRequestDtoToBook(BookAddRequestDto bookAddRequestDto){
        return Book.builder()
                .title(bookAddRequestDto.getTitle())
                .price(bookAddRequestDto.getPrice())
                .genere(bookAddRequestDto.getGenere())
                .isIssued(false)
                .build();
    }
    public static BookAddResponseDto BookToBookAddResponse(Book book){
        return BookAddResponseDto.builder()
                .title(book.getTitle())
                .price(book.getPrice())
                .build();
    }
}

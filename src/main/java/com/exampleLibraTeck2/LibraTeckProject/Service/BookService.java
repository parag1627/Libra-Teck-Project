package com.exampleLibraTeck2.LibraTeckProject.Service;

import com.exampleLibraTeck2.LibraTeckProject.RequestDto.BookAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.BookAddResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface BookService {

    public BookAddResponseDto addBook(BookAddRequestDto bookAddRequestDto);
    public BookAddResponseDto getAuthorByTitle(String title);

}

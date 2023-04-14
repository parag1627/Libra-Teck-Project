package com.exampleLibraTeck2.LibraTeckProject.Controller;

import com.exampleLibraTeck2.LibraTeckProject.RequestDto.BookAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.BookAddResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.GenericWebApplicationContext;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/add")
//    public BookAddResponseDto addBook(@RequestBody BookAddRequestDto bookAddRequestDto) throws Exception {

//        return bookService.addBook(bookAddRequestDto);
//    }
    public ResponseEntity addBook(@RequestBody BookAddRequestDto bookAddRequestDto) throws Exception {
        BookAddResponseDto bookAddResponseDto;
        try {
            bookAddResponseDto =  bookService.addBook(bookAddRequestDto);
            return new ResponseEntity<>(bookAddResponseDto,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_byTitle")
    public ResponseEntity getAuthorByTitle(@RequestParam ("title") String title){
        BookAddResponseDto bookAddResponseDto;
        try {
            bookAddResponseDto =   bookService.getAuthorByTitle(title);
            return new ResponseEntity(bookAddResponseDto,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
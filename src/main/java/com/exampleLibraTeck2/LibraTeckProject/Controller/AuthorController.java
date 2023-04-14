package com.exampleLibraTeck2.LibraTeckProject.Controller;

import com.exampleLibraTeck2.LibraTeckProject.Model.Author;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorList;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.AuthorAddResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor (@RequestBody Author author){

        try {
            authorService.addAuthor(author);
            return new ResponseEntity(author,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public ResponseEntity getAuthor(@RequestParam("id") int id){
        List<AuthorList> list;
        try {
          list=  authorService.getAuthor(id);
            return new ResponseEntity(list,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}

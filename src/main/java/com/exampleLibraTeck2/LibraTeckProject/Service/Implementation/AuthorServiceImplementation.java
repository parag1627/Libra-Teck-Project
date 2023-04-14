package com.exampleLibraTeck2.LibraTeckProject.Service.Implementation;

import com.exampleLibraTeck2.LibraTeckProject.Convertor.AuthorConvertor;
import com.exampleLibraTeck2.LibraTeckProject.Model.Author;
import com.exampleLibraTeck2.LibraTeckProject.Repository.AuthorRepository;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorList;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.AuthorAddResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public void addAuthor(Author author){

        authorRepository.save(author);
    }
//    public AuthorAddResponseDto addAuthor (Author author){
//       Author author= AuthorConvertor.AuthorAddRequestDtoToAuthor(authorAddRequestDto);
//
//       authorRepository.save(author);
//
//       AuthorAddResponseDto authorAddResponseDto= AuthorConvertor.
//               AuthorAddRequestDtoToAuthorResponse
//                       (authorAddRequestDto);
//        return  authorAddResponseDto;
//    }
    public List<AuthorList> getAuthor(int id) {
        Author author = authorRepository.findById(id).get();
        List<AuthorList> list = new ArrayList<>();
        if (author != null) {
            AuthorList authorList = AuthorConvertor.AuthorToAuthorList(author);
            list.add(authorList);
        }
        return list;
    }
}

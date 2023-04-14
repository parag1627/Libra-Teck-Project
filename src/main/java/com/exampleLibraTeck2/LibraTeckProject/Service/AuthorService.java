package com.exampleLibraTeck2.LibraTeckProject.Service;

import com.exampleLibraTeck2.LibraTeckProject.Model.Author;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorList;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.AuthorAddResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface AuthorService {

    public void addAuthor(Author author);

    public List<AuthorList> getAuthor(int id);
}

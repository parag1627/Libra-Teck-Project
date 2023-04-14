package com.exampleLibraTeck2.LibraTeckProject.Convertor;

import com.exampleLibraTeck2.LibraTeckProject.Model.Author;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorAddRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.AuthorList;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.AuthorAddResponseDto;

public class AuthorConvertor {

    public static Author AuthorAddRequestDtoToAuthor(AuthorAddRequestDto authorAddRequestDto){
        return Author.builder()
                .name(authorAddRequestDto.getName())
                .age(authorAddRequestDto.getAge())
                .email(authorAddRequestDto.getEmail())
                .mobNo(authorAddRequestDto.getMobNo())
                .build();
    }

    public static AuthorAddResponseDto AuthorAddRequestDtoToAuthorResponse(AuthorAddRequestDto authorAddRequestDto){
        return AuthorAddResponseDto.builder()
                .name(authorAddRequestDto.getName())
                .mobNo(authorAddRequestDto.getMobNo())
                .build();
    }
    public static AuthorList AuthorToAuthorList(Author author){
      return   AuthorList.builder()
              .name(author.getName())
              .build();
    }
}

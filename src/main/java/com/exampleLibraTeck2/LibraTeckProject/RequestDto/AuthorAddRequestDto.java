package com.exampleLibraTeck2.LibraTeckProject.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorAddRequestDto {
    private String name;

    private String email;

    private int age;

    private String mobNo;


}

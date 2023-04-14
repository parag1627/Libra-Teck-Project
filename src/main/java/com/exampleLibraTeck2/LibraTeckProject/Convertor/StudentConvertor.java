package com.exampleLibraTeck2.LibraTeckProject.Convertor;

import com.exampleLibraTeck2.LibraTeckProject.Model.Student;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.StudentRequestDto;

public class StudentConvertor {
    public static Student StudentRequestDtoTOStudent(StudentRequestDto studentRequestDto) {
        return Student.builder()
                .name(studentRequestDto.getName())
                .age(studentRequestDto.getAge())
                .email(studentRequestDto.getEmail())
                .department(studentRequestDto.getDepartment())
                .build();
    }
}
package com.exampleLibraTeck2.LibraTeckProject.Service;

import com.exampleLibraTeck2.LibraTeckProject.Model.Student;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.StudentRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.StudentUpdateEmailRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.StudentEmailUpdateResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface StudentService {

    public Student addStudent(StudentRequestDto studentRequestDto);
    public StudentEmailUpdateResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto);
}

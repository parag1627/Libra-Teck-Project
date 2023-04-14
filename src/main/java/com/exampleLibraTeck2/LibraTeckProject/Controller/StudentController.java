package com.exampleLibraTeck2.LibraTeckProject.Controller;

import com.exampleLibraTeck2.LibraTeckProject.RequestDto.StudentRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.StudentUpdateEmailRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.StudentEmailUpdateResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        try {
            studentService.addStudent(studentRequestDto);
            return new ResponseEntity("Student has been added", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
        @PutMapping("/update_email")
        public ResponseEntity updateEmail(@RequestBody  StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
            StudentEmailUpdateResponseDto studentEmailUpdateResponseDto;
            try {
                studentEmailUpdateResponseDto = studentService.updateEmail(studentUpdateEmailRequestDto);
                return new ResponseEntity(studentEmailUpdateResponseDto,HttpStatus.ACCEPTED);
        }
            catch (Exception e){
                return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
            }

    }
}

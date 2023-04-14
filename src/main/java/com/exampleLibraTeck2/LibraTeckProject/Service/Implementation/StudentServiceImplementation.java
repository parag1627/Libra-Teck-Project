package com.exampleLibraTeck2.LibraTeckProject.Service.Implementation;

import com.exampleLibraTeck2.LibraTeckProject.Convertor.StudentConvertor;
import com.exampleLibraTeck2.LibraTeckProject.Enum.CardStatus;
import com.exampleLibraTeck2.LibraTeckProject.Model.LibraryCard;
import com.exampleLibraTeck2.LibraTeckProject.Model.Student;
import com.exampleLibraTeck2.LibraTeckProject.Repository.StudentRepository;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.StudentRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.StudentUpdateEmailRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.StudentEmailUpdateResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student addStudent(StudentRequestDto studentRequestDto){


        Student student= StudentConvertor.StudentRequestDtoTOStudent(studentRequestDto);

        LibraryCard card= new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);

        return studentRepository.save(student);
    }
    public StudentEmailUpdateResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
         Student student= studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
         student.setEmail(studentUpdateEmailRequestDto.getEmail());

         Student updatedStudent = studentRepository.save(student);

         StudentEmailUpdateResponseDto studentEmailUpdateResponseDto = StudentEmailUpdateResponseDto.builder()
                 .name(updatedStudent.getName())
                 .email(updatedStudent.getEmail())
                 .build();
         return studentEmailUpdateResponseDto;
    }
}


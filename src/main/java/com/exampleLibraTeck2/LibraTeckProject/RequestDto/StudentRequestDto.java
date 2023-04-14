package com.exampleLibraTeck2.LibraTeckProject.RequestDto;

import com.exampleLibraTeck2.LibraTeckProject.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class StudentRequestDto {
    private String email;
    private int age;
    private String name;
    private Department department;
}

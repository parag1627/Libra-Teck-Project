package com.exampleLibraTeck2.LibraTeckProject.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class StudentEmailUpdateResponseDto {
    private String name;
    private String email;
}

package com.exampleLibraTeck2.LibraTeckProject.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class StudentUpdateEmailRequestDto {
    private int id;
    private String email;
}

package com.exampleLibraTeck2.LibraTeckProject.ResponseDto;

import lombok.*;
import org.springframework.data.annotation.AccessType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookAddResponseDto {
    private String title;

    private int price;

}

package com.exampleLibraTeck2.LibraTeckProject.RequestDto;

import com.exampleLibraTeck2.LibraTeckProject.Enum.Genere;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAddRequestDto {
    private String title;

    private int price;

    private Genere genere;

    private int authorId;

}

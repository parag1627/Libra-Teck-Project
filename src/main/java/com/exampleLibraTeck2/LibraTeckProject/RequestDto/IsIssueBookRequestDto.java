package com.exampleLibraTeck2.LibraTeckProject.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IsIssueBookRequestDto {
    private int bookId;

    private int libraryCardId;

}

package com.exampleLibraTeck2.LibraTeckProject.ResponseDto;

import com.exampleLibraTeck2.LibraTeckProject.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IsIssueBookResponseDto {

    private String transactionId;
    private String bookName;
    private TransactionStatus transactionStatus;

}

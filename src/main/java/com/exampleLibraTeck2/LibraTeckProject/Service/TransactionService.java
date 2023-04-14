package com.exampleLibraTeck2.LibraTeckProject.Service;

import com.exampleLibraTeck2.LibraTeckProject.RequestDto.IsIssueBookRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.IsIssueBookResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface TransactionService {

    public IsIssueBookResponseDto issueBook(IsIssueBookRequestDto issueBookRequestDto) throws Exception;
}

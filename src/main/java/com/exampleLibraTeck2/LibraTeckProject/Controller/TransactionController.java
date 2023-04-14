package com.exampleLibraTeck2.LibraTeckProject.Controller;

import com.exampleLibraTeck2.LibraTeckProject.RequestDto.IsIssueBookRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.IsIssueBookResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public ResponseEntity issueBook(@RequestBody IsIssueBookRequestDto issueBookRequestDto) throws Exception {
        IsIssueBookResponseDto issueBookResponseDTO;
        try{
            issueBookResponseDTO= transactionService.issueBook(issueBookRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity(issueBookResponseDTO, HttpStatus.ACCEPTED);
    }

//    @GetMapping("get")
//    public List<TransactionResponseDTO> getAllTxn(@RequestParam("cardId") int cardId){
//
//        return transactionService.getAllTxn(cardId);
//    }

}



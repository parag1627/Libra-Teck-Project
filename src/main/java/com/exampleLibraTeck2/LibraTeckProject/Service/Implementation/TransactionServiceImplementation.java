package com.exampleLibraTeck2.LibraTeckProject.Service.Implementation;

import com.exampleLibraTeck2.LibraTeckProject.Enum.CardStatus;
import com.exampleLibraTeck2.LibraTeckProject.Enum.TransactionStatus;
import com.exampleLibraTeck2.LibraTeckProject.Model.Book;
import com.exampleLibraTeck2.LibraTeckProject.Model.LibraryCard;
import com.exampleLibraTeck2.LibraTeckProject.Model.Transactions;
import com.exampleLibraTeck2.LibraTeckProject.Repository.BookRepository;
import com.exampleLibraTeck2.LibraTeckProject.Repository.LibraryCardRepository;
import com.exampleLibraTeck2.LibraTeckProject.Repository.TransactionRepository;
import com.exampleLibraTeck2.LibraTeckProject.RequestDto.IsIssueBookRequestDto;
import com.exampleLibraTeck2.LibraTeckProject.ResponseDto.IsIssueBookResponseDto;
import com.exampleLibraTeck2.LibraTeckProject.Service.TransactionService;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Synchronization;
import java.util.UUID;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryCardRepository libraryCardRepository;

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    private JavaMailSender emailSender;


    public IsIssueBookResponseDto issueBook(IsIssueBookRequestDto issueBookRequestDto) throws Exception {

        Transactions transaction = new Transactions();
        transaction.setTransactionNo(String.valueOf(UUID.randomUUID()));
        transaction.setIssuedOperation(true);


        LibraryCard card;
        try {
            card = libraryCardRepository.findById(issueBookRequestDto.getLibraryCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Card Id");
            transactionRepository.save(transaction);
            //because from here we have to send failed or return so save here
            throw new Exception("Invalid Card Id");
        }

        Book book;
        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }

        transaction.setBook(book);
        transaction.setCard(card);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not Activated");
            transactionRepository.save(transaction);
            throw new Exception("Your card is not Activated");
        }
        if(book.isIssued()){ //means if book isIssued == true
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your book is not available");
            transactionRepository.save(transaction);
            throw new Exception("Your book is not available");
        }

        //now I can issue the book
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction is successful");
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionsList().add(transaction);


        card.getTransactionsList().add(transaction);
        card.getBookIssued().add(book);

        libraryCardRepository.save(card);
        //because card is the parent of transaction and book

        IsIssueBookResponseDto isIssueBookResponseDto = new IsIssueBookResponseDto();
        isIssueBookResponseDto.setBookName(book.getTitle());
        isIssueBookResponseDto.setTransactionId(transaction.getTransactionNo());
        isIssueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);

        String text = "Congrats !!." + card.getStudent().getName()+ "You have been issued "+book.getTitle()+" book.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendavengers@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issue Book Notification");
        message.setText(text);
        emailSender.send(message);

        return isIssueBookResponseDto;
    }
}

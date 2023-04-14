package com.exampleLibraTeck2.LibraTeckProject.Model;

import com.exampleLibraTeck2.LibraTeckProject.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionNo;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssuedOperation;

    private String Message;

    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard card;



}
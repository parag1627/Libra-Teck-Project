package com.exampleLibraTeck2.LibraTeckProject.Model;

import com.exampleLibraTeck2.LibraTeckProject.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Transaction;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@Table(name = "libraryCard")

public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cardId")
    private int id;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updatedDate;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;


    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Transactions> transactionsList = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> bookIssued= new ArrayList<>();


}

package com.exampleLibraTeck2.LibraTeckProject.Model;


import com.exampleLibraTeck2.LibraTeckProject.Enum.Genere;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int price;
    private boolean isIssued;

    @Enumerated(EnumType.STRING)
    Genere genere;

   @ManyToOne
   @JoinColumn
   Author author;

  @ManyToOne
  @JoinColumn
  LibraryCard card;

  @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transactions> transactionsList = new ArrayList<>();

}
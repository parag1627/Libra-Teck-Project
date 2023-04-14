package com.exampleLibraTeck2.LibraTeckProject.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
        private String email;
        private int age;
        private String mobNo;

      @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
      List<Book> bookList = new ArrayList<>();

    }

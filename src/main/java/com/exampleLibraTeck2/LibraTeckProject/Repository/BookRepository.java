package com.exampleLibraTeck2.LibraTeckProject.Repository;

import com.exampleLibraTeck2.LibraTeckProject.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByTitle(String title);
}

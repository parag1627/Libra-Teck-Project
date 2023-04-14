package com.exampleLibraTeck2.LibraTeckProject.Repository;

import com.exampleLibraTeck2.LibraTeckProject.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}

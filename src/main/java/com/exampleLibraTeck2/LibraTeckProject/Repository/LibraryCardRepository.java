package com.exampleLibraTeck2.LibraTeckProject.Repository;

import com.exampleLibraTeck2.LibraTeckProject.Model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}

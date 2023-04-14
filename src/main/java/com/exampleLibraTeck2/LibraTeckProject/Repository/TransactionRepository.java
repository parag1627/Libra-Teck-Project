package com.exampleLibraTeck2.LibraTeckProject.Repository;

import com.exampleLibraTeck2.LibraTeckProject.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

}

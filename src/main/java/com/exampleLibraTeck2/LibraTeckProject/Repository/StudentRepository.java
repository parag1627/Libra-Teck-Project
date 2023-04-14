package com.exampleLibraTeck2.LibraTeckProject.Repository;

import com.exampleLibraTeck2.LibraTeckProject.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

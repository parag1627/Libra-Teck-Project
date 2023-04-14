package com.exampleLibraTeck2.LibraTeckProject.Model;

import com.exampleLibraTeck2.LibraTeckProject.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(nullable = false)
    private String email;


    @Enumerated(EnumType.STRING)
    private Department department;


    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard card;

}

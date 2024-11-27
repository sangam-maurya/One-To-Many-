package com.example.OneToMany.EntityOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Empolyee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
//    @JsonBackReference
    private  Department department;
}

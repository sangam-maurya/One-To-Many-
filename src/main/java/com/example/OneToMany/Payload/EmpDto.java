package com.example.OneToMany.Payload;

import com.example.OneToMany.EntityOne.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDto {
    private long id;
    private String name;
    private double salary;
//    private Department department;
}

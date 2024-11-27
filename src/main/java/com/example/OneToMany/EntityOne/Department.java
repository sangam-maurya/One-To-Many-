package com.example.OneToMany.EntityOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String postion;

    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL ,orphanRemoval = true)
//    @JsonManagedReference
    private List<Empolyee>empolyees = new ArrayList<>();
    public void addEmployee(Empolyee employee) {
        empolyees.add(employee);
        employee.setDepartment(this); // Important: Setting the department for the employee
    }


}

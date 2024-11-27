package com.example.OneToMany.Payload;

import com.example.OneToMany.EntityOne.Department;
import com.example.OneToMany.EntityOne.Empolyee;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartDto {
    private  long id;
    private String postion;
    private List<EmpDto> empolyees;

}

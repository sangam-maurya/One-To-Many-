package com.example.OneToMany.Controller;


import com.example.OneToMany.EntityOne.Empolyee;
import com.example.OneToMany.Payload.EmpDto;
import com.example.OneToMany.Service.EmpService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/OneToOne")
public class EmpController {
    @Autowired
    private EmpService employeeService;

    @PostMapping
    public EmpDto createEmployee(@RequestBody EmpDto employeeDto) {
        return employeeService.registerEmployee(employeeDto);
    }

    @GetMapping
    public List<EmpDto> getAllData(){
        List<EmpDto> empDtos = employeeService.findallData();
        return empDtos;
    }
}


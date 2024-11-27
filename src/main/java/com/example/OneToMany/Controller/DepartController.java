package com.example.OneToMany.Controller;

import com.example.OneToMany.EntityOne.Department;
import com.example.OneToMany.Payload.DepartDto;
import com.example.OneToMany.Service.DepartMentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private DepartMentService service;
    @PostMapping
    public Department createReg(@RequestBody Department department){
        Department department1 = service.registerDepartment(department);
        return department;
    }

    @GetMapping
    public List<DepartDto> findAllData(){
        List<DepartDto> allData = service.getAllData();
        return allData;
    }
}

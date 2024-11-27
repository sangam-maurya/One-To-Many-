package com.example.OneToMany.Service;

import com.example.OneToMany.EntityOne.Department;
import com.example.OneToMany.EntityOne.Empolyee;
import com.example.OneToMany.Payload.EmpDto;
import com.example.OneToMany.empRepo.DepartmentRepository;
import com.example.OneToMany.empRepo.EmpolyeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmpService {
    private final EmpolyeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;

    @Transactional
    public EmpDto registerEmployee(EmpDto employeeDto) {
        Empolyee employee = mapper.map(employeeDto, Empolyee.class);
        Department department = employee.getDepartment();
        Optional<Department> existingDepartment = departmentRepository.findById(department.getId());
        if (existingDepartment.isPresent()) {
            department = existingDepartment.get();
        } else {
            department = departmentRepository.save(department);
        }
        employee.setDepartment(department);
        Empolyee savedEmployee = employeeRepository.save(employee);
        return mapper.map(savedEmployee, EmpDto.class);
    }

    public List<EmpDto>findallData(){
        List<Empolyee> all = employeeRepository.findAll();
        List<EmpDto> list = all.stream().map(r -> mapToDto(r)).toList();
        return list;
    }

    public EmpDto mapToDto(Empolyee empolyee){
        EmpDto map = mapper.map(empolyee, EmpDto.class);
        return map;
    }
}

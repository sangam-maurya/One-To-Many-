package com.example.OneToMany.Service;

import com.example.OneToMany.EntityOne.Department;
import com.example.OneToMany.EntityOne.Empolyee;
import com.example.OneToMany.Payload.DepartDto;
import com.example.OneToMany.Payload.EmpDto;
import com.example.OneToMany.empRepo.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartMentService {
    private final DepartmentRepository repository;
    private final ModelMapper mapper;
    @Transactional
    public Department registerDepartment(Department department) {
        if (department.getEmpolyees() == null) {
            department.setEmpolyees(new ArrayList<>());
        }
        department.getEmpolyees().forEach(emp -> emp.setDepartment(department));
        return repository.save(department);
    }


    public List<DepartDto> getAllData(){
        List<Department> all = repository.findAll();
        List<DepartDto> list = all.stream().map(r -> convertToDto(r)).toList();
        return list;
    }
    public DepartDto  convertToDto(Department department) {
        DepartDto departDto = new DepartDto();
        departDto.setId(department.getId());
        departDto.setPostion(department.getPostion());
        // Converting Employees to EmpDto list
        List<EmpDto> employeeDtos = department.getEmpolyees() != null
                ? department.getEmpolyees().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList())
                : new ArrayList<>();
        departDto.setEmpolyees(employeeDtos); // Setting EmpDto list in DTO
        return departDto;
    }
    public EmpDto mapToDto(Empolyee empolyee) {
        EmpDto empDto = new EmpDto();
        empDto.setId(empolyee.getId());
        empDto.setName(empolyee.getName());
        empDto.setSalary(empolyee.getSalary());
        return empDto;
}
    }
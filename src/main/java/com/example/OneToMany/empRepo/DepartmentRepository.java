package com.example.OneToMany.empRepo;

import com.example.OneToMany.EntityOne.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
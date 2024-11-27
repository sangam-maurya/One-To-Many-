package com.example.OneToMany.empRepo;

import com.example.OneToMany.EntityOne.Empolyee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpolyeeRepository extends JpaRepository<Empolyee, Long> {
}
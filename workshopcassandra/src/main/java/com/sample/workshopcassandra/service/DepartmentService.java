package com.sample.workshopcassandra.service;

import com.sample.workshopcassandra.model.dto.CreateDepartmentDTO;
import com.sample.workshopcassandra.model.dto.DepartmentDTO;
import com.sample.workshopcassandra.model.dto.UpdateDepartmentDTO;
import com.sample.workshopcassandra.model.entities.Department;
import com.sample.workshopcassandra.repositories.DepartmentRepository;
import com.sample.workshopcassandra.service.exception.ResourceNotFound;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDTO> departments(){
        var departments = departmentRepository.findAll();
        return departments.stream().map( x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }

    public DepartmentDTO findByUUID(UUID uuid){
        Optional<Department> departmentResponse = departmentRepository.findById(uuid);
        Department department = departmentResponse.orElseThrow(() -> new ResourceNotFound("Id nao encontrado"));
        return new DepartmentDTO(department);
    }

    public Department saveDepartment(CreateDepartmentDTO createDepartmentDTO){
        Department department = new Department();
        department.setName(createDepartmentDTO.getName());
        department.setId(createDepartmentDTO.getUuid());
        departmentRepository.save(department);
        return department;
    }

    public Department getById(UUID uuid){
        Optional<Department> departmentResponse = departmentRepository.findById(uuid);
        Department department = departmentResponse.orElseThrow(() -> new ResourceNotFound("Id nao encontrado"));
        return department;
    }

    public void updateDepartment(UUID uuid, UpdateDepartmentDTO updateDepartmentDTO) {

        Department department = getById(uuid);
        copyDtoToEntity(updateDepartmentDTO,department);

        departmentRepository.save(department);

    }
    private void copyDtoToEntity(UpdateDepartmentDTO dto,Department entity){
        entity.setName(dto.getName());
    }

    public void deleteDepartment(UUID id) {
        Department department = getById(id);
        departmentRepository.delete(department);
    }
}

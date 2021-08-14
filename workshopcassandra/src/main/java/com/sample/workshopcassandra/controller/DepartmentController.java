package com.sample.workshopcassandra.controller;


import com.sample.workshopcassandra.model.dto.CreateDepartmentDTO;
import com.sample.workshopcassandra.model.dto.DepartmentDTO;
import com.sample.workshopcassandra.model.dto.UpdateDepartmentDTO;
import com.sample.workshopcassandra.model.entities.Department;
import com.sample.workshopcassandra.service.DepartmentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> departments(){
        return ResponseEntity.ok(departmentService.departments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> findByUUIDDepartment(@PathVariable UUID id){
        return ResponseEntity.ok(departmentService.findByUUID(id));
    }
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody  CreateDepartmentDTO createDepartmentDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createDepartmentDTO.getUuid()).toUri();
        return ResponseEntity.created(uri).body(departmentService.saveDepartment(createDepartmentDTO)); //new ResponseEntity<>(departmentService.saveDepartment(createDepartmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDepartment(@PathVariable UUID id, @RequestBody UpdateDepartmentDTO updateDepartmentDTO) {
        departmentService.updateDepartment(id, updateDepartmentDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDepartment(@PathVariable UUID id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

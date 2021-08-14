package com.sample.workshopcassandra.model.dto;

import com.sample.workshopcassandra.model.entities.Department;

import java.util.UUID;

public class DepartmentDTO {

    private UUID id;
    private String name;

    public DepartmentDTO(){

    }
    public DepartmentDTO(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public DepartmentDTO(Department department){
        this.name = department.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

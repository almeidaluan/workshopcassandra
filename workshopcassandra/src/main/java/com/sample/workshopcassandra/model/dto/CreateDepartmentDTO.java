package com.sample.workshopcassandra.model.dto;

import com.sample.workshopcassandra.model.entities.Department;

import java.util.UUID;

public class CreateDepartmentDTO {

    public UUID uuid;
    public String name;

    public CreateDepartmentDTO(){

    }

    public CreateDepartmentDTO(String name){
        setUuid(UUID.randomUUID());
        this.name = name;
    }

    public UUID getUuid() {
        return UUID.randomUUID();
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

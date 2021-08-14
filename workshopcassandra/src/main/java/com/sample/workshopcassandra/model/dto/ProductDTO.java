package com.sample.workshopcassandra.model.dto;

import com.sample.workshopcassandra.model.embedded.Prop;
import com.sample.workshopcassandra.model.entities.Product;
import org.springframework.data.cassandra.core.mapping.Frozen;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductDTO {

    private UUID id;

    private String department;
    private Double price;
    private Instant moment;
    private String name;
    private String description;
    private List<Prop> props = new ArrayList<Prop>();


    public ProductDTO(Product product) {
        this.id = product.getId();
        this.department = product.getDepartment();
        this.price = product.getPrice();
        this.moment = product.getMoment();
        this.name = product.getName();
        this.description = product.getDescription();
        this.props.addAll(product.getProps());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Prop> getProps() {
        return props;
    }

    public void setProps(List<Prop> props) {
        this.props = props;
    }
}

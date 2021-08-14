package com.sample.workshopcassandra.repositories;

import com.sample.workshopcassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {

    @AllowFiltering // Para possibilitar a consulta por uma string no cassandra, necessita do allowfiltering
    List<Product> findByDepartment(String department);
}

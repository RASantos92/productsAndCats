package com.proandcat.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proandcat.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}

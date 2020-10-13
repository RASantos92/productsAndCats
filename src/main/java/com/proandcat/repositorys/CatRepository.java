package com.proandcat.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proandcat.models.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

}

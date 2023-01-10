package com.practice.productbooking.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.productbooking.model.Production;
@Repository

public interface ProdRepository extends MongoRepository<Production, String>{

}
